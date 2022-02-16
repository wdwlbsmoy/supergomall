package com.supergo.search.repository;

import com.supergo.search.entity.GoodsEntity;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * @Auther:xueruiheng
 * @Date:2022/2/7
 * @Description:com.supergo.search.repository
 * @version:1.0
 */
public interface GoodsRepository extends ElasticsearchRepository<GoodsEntity,Long> {
}
