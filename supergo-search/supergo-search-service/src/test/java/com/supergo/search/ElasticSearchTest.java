package com.supergo.search;

import com.supergo.search.entity.UserEntity;
import com.supergo.search.repository.UserRepository;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.aggregations.Aggregation;
import org.elasticsearch.search.aggregations.AggregationBuilders;
import org.elasticsearch.search.aggregations.Aggregations;
import org.elasticsearch.search.aggregations.bucket.terms.TermsAggregationBuilder;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightField;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.SearchResultMapper;
import org.springframework.data.elasticsearch.core.aggregation.AggregatedPage;
import org.springframework.data.elasticsearch.core.aggregation.impl.AggregatedPageImpl;
import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @Auther:xueruiheng
 * @Date:2022/2/7
 * @Description:com.supergo.search
 * @version:1.0
 */

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SearchServiceApplication.class)
public class ElasticSearchTest {
    @Autowired
    private ElasticsearchTemplate elasticsearchTemplate;

    @Autowired
    private UserRepository userRepository;

    @Test
    public void createIndex(){
        elasticsearchTemplate.createIndex(UserEntity.class);
    }

    @Test
    public void putMappings(){
        elasticsearchTemplate.putMapping(UserEntity.class);
    }

    @Test
    public void deleteIndex(){
        elasticsearchTemplate.deleteIndex(UserEntity.class);
    }

    @Test
    public void addDoucument(){
        for (int i = 0; i < 20; i++) {
            //创建一个实体类对象
            UserEntity userEntity = new UserEntity();
            //设置属性
            userEntity.setId(i+1);
            userEntity.setName("张华" + i);
            userEntity.setAddress("北京市海淀区" + i);
            if (i % 2 == 0){
                userEntity.setSex("女");
            }else {
                userEntity.setSex("男");
            }
            //使用userRepository写入索引库
            userRepository.save(userEntity);
        }
    }

    @Test
    public void updateDoucument(){
        //创建一个实体类对象
        UserEntity userEntity = new UserEntity();
        //设置属性
        userEntity.setId(1);
        userEntity.setName("张华英");
        userEntity.setAddress("北京市东城区");
        userEntity.setSex("女");
        //使用userRepository写入索引库
        userRepository.save(userEntity);
    }

    @Test
    public void deleteDocument(){
        userRepository.deleteById(1);
    }

    //查询方法
    @Test
    public void testFindById(){
        Optional<UserEntity> result = userRepository.findById(1);
        if (result.isPresent()){
            UserEntity userEntity = result.get();
            System.out.println(userEntity);
        }
    }

    @Test
    public void testFindByName(){
        List<UserEntity> list = userRepository.findByName("张华");
        list.forEach(u-> System.out.println(u));
    }

    @Test
    public void testSimpleQuery(){
        //创建一个查询对象
        SearchQuery query = new NativeSearchQueryBuilder()
                //在查询对象中封装查询条件
//                .withQuery(QueryBuilders.queryStringQuery("北京欢迎你").defaultField("address"))
                .withQuery(QueryBuilders.boolQuery()
                        .must(QueryBuilders.termQuery("name","张华"))
                        .must(QueryBuilders.termQuery("address","北京"))
                        .filter(QueryBuilders.termQuery("sex","女"))
                )
                .withPageable(PageRequest.of(1,5))
                .build();
        //使用ElasticSearchTemplate对象执行查询
        List<UserEntity> list = elasticsearchTemplate.queryForList(query, UserEntity.class);
        list.forEach(u-> System.out.println(u));
    }

    @Test
    public void testHigthlightQuery(){
        //创建一个聚合条件
        TermsAggregationBuilder aggregationBuilder = AggregationBuilders.terms("sex_count").field("sex");
        //创建一个查询对象
        SearchQuery query = new NativeSearchQueryBuilder()
                .withQuery(QueryBuilders.termQuery("address","北京"))
                .addAggregation(aggregationBuilder)
                .withPageable(PageRequest.of(1,10))
                //设置高亮
                .withHighlightFields(new HighlightBuilder.Field("address").preTags("<em>").postTags("</em>"))
                .build();
        //执行查询
        AggregatedPage<UserEntity> aggregatedPage = elasticsearchTemplate.queryForPage(query, UserEntity.class, new SearchResultMapper() {
            @Override
            public <T> AggregatedPage<T> mapResults(SearchResponse searchResponse, Class<T> aClass, Pageable pageable) {
                //取响应的结果
                SearchHits searchHits = searchResponse.getHits();
                //取返回结果的总记录数
                long totalHits = searchHits.getTotalHits();
                //文档列表
                SearchHit[] hits = searchHits.getHits();
                ArrayList<UserEntity> list = new ArrayList<>();
                for (SearchHit hit : hits) {
                    //创建一个UserEntity对象
                    UserEntity userEntity = new UserEntity();
                    //封装属性
                    //把结果封装成UserEntity对象
                    userEntity.setId((Integer) hit.getSourceAsMap().get("id"));
                    userEntity.setName((String) hit.getSourceAsMap().get("name"));
                    userEntity.setSex((String) hit.getSourceAsMap().get("sex"));
//                    userEntity.setAddress((String) hit.getSourceAsMap().get("address"));
                    //取高亮结果,用高亮结果替代address
                    HighlightField highlightField = hit.getHighlightFields().get("address");
                    String hlResult = highlightField.getFragments()[0].string();
                    userEntity.setAddress(hlResult);
                    //添加到list中
                    list.add(userEntity);
                }
                //把结果封装成AggregatedPage对象返回
                AggregatedPage aggregatedPage = new AggregatedPageImpl(list, pageable, totalHits, searchResponse.getAggregations());
                return aggregatedPage;
            }

            @Override
            public <T> T mapSearchHit(SearchHit searchHit, Class<T> aClass) {
                return null;
            }
        });
        //聚合结果
        Aggregations aggregations = aggregatedPage.getAggregations();
        aggregations.forEach(a-> System.out.println(a));
        //取查询结果
        List<UserEntity> list = aggregatedPage.getContent();
        list.forEach(u-> System.out.println(u));
    }
}
