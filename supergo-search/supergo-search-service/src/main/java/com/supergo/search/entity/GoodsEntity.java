package com.supergo.search.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

/**
 * @Auther:xueruiheng
 * @Date:2022/2/7
 * @Description:com.supergo.search.entity
 * @version:1.0
 */
@Document(indexName = "supergo", type = "goods")
public class GoodsEntity {
    @Id
    @Field(type = FieldType.Long, store = true)
    private long id;
    @Field(type = FieldType.Text, store = true, analyzer = "ik_max_word")
    private String goods_name;
    @Field(type = FieldType.Keyword, store = true)
    private String seller_id;
    @Field(type = FieldType.Keyword, store = true)
    private String nick_name;
    @Field(type = FieldType.Long, store = true)
    private long brand_id;
    @Field(type = FieldType.Keyword, store = true)
    private String brand_name;
    @Field(type = FieldType.Long, store = true)
    private long category1_id;
    @Field(type = FieldType.Keyword, store = true)
    private String cname1;
    @Field(type = FieldType.Long, store = true)
    private long category2_id;
    @Field(type = FieldType.Keyword, store = true)
    private String cname2;
    @Field(type = FieldType.Long, store = true)
    private long category3_id;
    @Field(type = FieldType.Keyword, store = true)
    private String cname3;
    @Field(type = FieldType.Keyword, store = true, index = false)
    private String small_pic;
    @Field(type = FieldType.Float, store = true)
    private double price;

    public long getId() {
        return id;
    }

    public GoodsEntity setId(long id) {
        this.id = id;
        return this;
    }

    public String getGoods_name() {
        return goods_name;
    }

    public GoodsEntity setGoods_name(String goods_name) {
        this.goods_name = goods_name;
        return this;
    }

    public String getSeller_id() {
        return seller_id;
    }

    public GoodsEntity setSeller_id(String seller_id) {
        this.seller_id = seller_id;
        return this;
    }

    public String getNick_name() {
        return nick_name;
    }

    public GoodsEntity setNick_name(String nick_name) {
        this.nick_name = nick_name;
        return this;
    }

    public long getBrand_id() {
        return brand_id;
    }

    public GoodsEntity setBrand_id(long brand_id) {
        this.brand_id = brand_id;
        return this;
    }

    public String getBrand_name() {
        return brand_name;
    }

    public GoodsEntity setBrand_name(String brand_name) {
        this.brand_name = brand_name;
        return this;
    }

    public long getCategory1_id() {
        return category1_id;
    }

    public GoodsEntity setCategory1_id(long category1_id) {
        this.category1_id = category1_id;
        return this;
    }

    public String getCname1() {
        return cname1;
    }

    public GoodsEntity setCname1(String cname1) {
        this.cname1 = cname1;
        return this;
    }

    public long getCategory2_id() {
        return category2_id;
    }

    public GoodsEntity setCategory2_id(long category2_id) {
        this.category2_id = category2_id;
        return this;
    }

    public String getCname2() {
        return cname2;
    }

    public GoodsEntity setCname2(String cname2) {
        this.cname2 = cname2;
        return this;
    }

    public long getCategory3_id() {
        return category3_id;
    }

    public GoodsEntity setCategory3_id(long category3_id) {
        this.category3_id = category3_id;
        return this;
    }

    public String getCname3() {
        return cname3;
    }

    public GoodsEntity setCname3(String cname3) {
        this.cname3 = cname3;
        return this;
    }

    public String getSmall_pic() {
        return small_pic;
    }

    public GoodsEntity setSmall_pic(String small_pic) {
        this.small_pic = small_pic;
        return this;
    }

    public double getPrice() {
        return price;
    }

    public GoodsEntity setPrice(double price) {
        this.price = price;
        return this;
    }
}
