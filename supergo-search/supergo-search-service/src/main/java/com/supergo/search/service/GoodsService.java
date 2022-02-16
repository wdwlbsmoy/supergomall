package com.supergo.search.service;

import com.supergo.http.HttpResult;
import com.supergo.search.entity.GoodsEntity;
import com.supergo.search.mapper.GoodsMapper;
import com.supergo.search.repository.GoodsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Auther:xueruiheng
 * @Date:2022/2/7
 * @Description:索引库维护Service
 * @version:1.0
 */
@Service
public class GoodsService {

    @Autowired
    private GoodsMapper goodsMapper;

    @Autowired
    private GoodsRepository goodsRepository;

    public HttpResult importGoodsList(){
        //查询数据库将商品列表查询出来
        List<GoodsEntity> goodsList = goodsMapper.getGoodsList();
        //把商品列表写入索引库
        goodsList.forEach(g->goodsRepository.save(g));
        //返回结果
        return HttpResult.ok();
    }
}
