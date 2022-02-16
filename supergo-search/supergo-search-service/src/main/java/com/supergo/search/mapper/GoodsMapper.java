package com.supergo.search.mapper;

import com.supergo.search.entity.GoodsEntity;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Auther:xueruiheng
 * @Date:2022/2/7
 * @Description:com.supergo.search.mapper
 * @version:1.0
 */
public interface GoodsMapper {
    @Select("SELECT\n" +
            "a.id,\n" +
            "a.goods_name,\n" +
            "a.seller_id,\n" +
            "b.nick_name,\n" +
            "a.brand_id,\n" +
            "c.name brand_name,\n" +
            "a.category1_id,\n" +
            "d.NAME cname1,\n" +
            "a.category2_id,\n" +
            "e.NAME cname2,\n" +
            "a.category3_id,\n" +
            "f.NAME cname3,\n" +
            "a.small_pic,\n" +
            "a.price\n" +
            "FROM\n" +
            "tb_goods a\n" +
            "LEFT JOIN tb_seller b ON a.seller_id = b.seller_id\n" +
            "LEFT JOIN tb_brand c ON a.brand_id = c.id\n" +
            "LEFT JOIN tb_item_cat d ON a.category1_id = d.id\n" +
            "LEFT JOIN tb_item_cat e ON a.category2_id = e.id\n" +
            "LEFT JOIN tb_item_cat f ON a.category3_id = f.id\n" +
            "WHERE\n" +
            "a.is_delete = 0\n" +
            "AND a.is_marketable = 1\n")
    List<GoodsEntity> getGoodsList();
}
