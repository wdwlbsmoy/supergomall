package com.supergo.manager.service.impl;

import com.supergo.http.HttpResult;
import com.supergo.manager.service.ItemCatService;
import com.supergo.mapper.ItemcatMapper;
import com.supergo.pojo.Itemcat;
import com.supergo.service.base.impl.BaseServiceImpl;
import com.supergo.user.utils.JsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @Auther:xueruiheng
 * @Date:2022/2/3
 * @Description:com.supergo.manager.service.impl
 * @version:1.0
 * 商品分类管理service
 */
@Service
public class ItemCatServiceImpl extends BaseServiceImpl<Itemcat> implements ItemCatService {

    @Autowired
    private ItemcatMapper itemcatMapper;

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Override
    public HttpResult getItemCatList() {
        //判断缓存中是否有数据
        try {
            String data = redisTemplate.opsForValue().get("item-category");
            if (data != null && !"".equals(data)){
                //如果缓存中有数据直接返回
                List<Itemcat> list = JsonUtils.jsonToList(data, Itemcat.class);
                return HttpResult.ok(list);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        //如果没有数据查询数据库
        //查询分类列表
        List<Itemcat> list = itemCatgorys(0);
        //把结果添加到缓存
        try {
            redisTemplate.opsForValue().set("item-category",JsonUtils.objectToJson(list));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return HttpResult.ok(list);
    }

    private List<Itemcat> itemCatgorys(long parentId){
        //根据parentid查询子节点列表
        Example example = new Example(Itemcat.class);
        Example.Criteria criteria = example.createCriteria();
        //设置查询条件
        criteria.andEqualTo("parentId",parentId);
        // 根据查询条件执行查询
        List<Itemcat> list = itemcatMapper.selectByExample(example);
        //判断列表中是否有数据
        if (list == null || list.size() == 0){
            //如果没有数据直接返回
            return null;
        }
        //如果有数据调用本方法查询子节点列表
        list.forEach(itemcat -> itemcat.setChildren(itemCatgorys(itemcat.getId())));
        //返回分类列表
        return list;
    }
}
