package com.supergo.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@ApiModel(value="com.supergo.pojo.Item")
@Table(name = "tb_item")
public class Item implements Serializable {
    /**
     * 商品id，同时也是商品编号
     */
    @Id
    @ApiModelProperty(value="id商品id，同时也是商品编号")
    private Long id;

    /**
     * 商品标题
     */
    @ApiModelProperty(value="title商品标题")
    private String title;

    /**
     * 商品卖点
     */
    @Column(name = "sell_point")
    @ApiModelProperty(value="sellPoint商品卖点")
    private String sellPoint;

    /**
     * 商品价格，单位为：元
     */
    @ApiModelProperty(value="price商品价格，单位为：元")
    private BigDecimal price;

    /**
     * 剩余库存
     */
    @Column(name = "stock_count")
    @ApiModelProperty(value="stockCount剩余库存")
    private Integer stockCount;

    /**
     * 库存数量
     */
    @ApiModelProperty(value="num库存数量")
    private Integer num;

    /**
     * 商品条形码
     */
    @ApiModelProperty(value="barcode商品条形码")
    private String barcode;

    /**
     * 商品图片
     */
    @ApiModelProperty(value="image商品图片")
    private String image;

    /**
     * 所属类目，叶子类目
     */
    @Column(name = "category_id")
    @ApiModelProperty(value="categoryId所属类目，叶子类目")
    private Long categoryId;

    /**
     * 商品状态，1-正常，2-下架，3-删除
     */
    @ApiModelProperty(value="status商品状态，1-正常，2-下架，3-删除")
    private String status;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    @ApiModelProperty(value="createTime创建时间")
    private Date createTime;

    /**
     * 更新时间
     */
    @Column(name = "update_time")
    @ApiModelProperty(value="updateTime更新时间")
    private Date updateTime;

    @Column(name = "item_sn")
    @ApiModelProperty(value="itemSn")
    private String itemSn;

    @Column(name = "cost_pirce")
    @ApiModelProperty(value="costPirce")
    private BigDecimal costPirce;

    @Column(name = "market_price")
    @ApiModelProperty(value="marketPrice")
    private BigDecimal marketPrice;

    @Column(name = "is_default")
    @ApiModelProperty(value="isDefault")
    private String isDefault;

    @Column(name = "goods_id")
    @ApiModelProperty(value="goodsId")
    private Long goodsId;

    @Column(name = "seller_id")
    @ApiModelProperty(value="sellerId")
    private String sellerId;

    @Column(name = "cart_thumbnail")
    @ApiModelProperty(value="cartThumbnail")
    private String cartThumbnail;

    @ApiModelProperty(value="category")
    private String category;

    @ApiModelProperty(value="brand")
    private String brand;

    @ApiModelProperty(value="spec")
    private String spec;

    @ApiModelProperty(value="seller")
    private String seller;

    private static final long serialVersionUID = 1L;

    public Item(Long id, String title, String sellPoint, BigDecimal price, Integer stockCount, Integer num, String barcode, String image, Long categoryId, String status, Date createTime, Date updateTime, String itemSn, BigDecimal costPirce, BigDecimal marketPrice, String isDefault, Long goodsId, String sellerId, String cartThumbnail, String category, String brand, String spec, String seller) {
        this.id = id;
        this.title = title;
        this.sellPoint = sellPoint;
        this.price = price;
        this.stockCount = stockCount;
        this.num = num;
        this.barcode = barcode;
        this.image = image;
        this.categoryId = categoryId;
        this.status = status;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.itemSn = itemSn;
        this.costPirce = costPirce;
        this.marketPrice = marketPrice;
        this.isDefault = isDefault;
        this.goodsId = goodsId;
        this.sellerId = sellerId;
        this.cartThumbnail = cartThumbnail;
        this.category = category;
        this.brand = brand;
        this.spec = spec;
        this.seller = seller;
    }

    public Item() {
        super();
    }

    /**
     * 获取商品id，同时也是商品编号
     *
     * @return id - 商品id，同时也是商品编号
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置商品id，同时也是商品编号
     *
     * @param id 商品id，同时也是商品编号
     */
    public Item setId(Long id) {
        this.id = id;
        return this;
    }

    /**
     * 获取商品标题
     *
     * @return title - 商品标题
     */
    public String getTitle() {
        return title;
    }

    /**
     * 设置商品标题
     *
     * @param title 商品标题
     */
    public Item setTitle(String title) {
        this.title = title;
        return this;
    }

    /**
     * 获取商品卖点
     *
     * @return sell_point - 商品卖点
     */
    public String getSellPoint() {
        return sellPoint;
    }

    /**
     * 设置商品卖点
     *
     * @param sellPoint 商品卖点
     */
    public Item setSellPoint(String sellPoint) {
        this.sellPoint = sellPoint;
        return this;
    }

    /**
     * 获取商品价格，单位为：元
     *
     * @return price - 商品价格，单位为：元
     */
    public BigDecimal getPrice() {
        return price;
    }

    /**
     * 设置商品价格，单位为：元
     *
     * @param price 商品价格，单位为：元
     */
    public Item setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    /**
     * 获取剩余库存
     *
     * @return stock_count - 剩余库存
     */
    public Integer getStockCount() {
        return stockCount;
    }

    /**
     * 设置剩余库存
     *
     * @param stockCount 剩余库存
     */
    public Item setStockCount(Integer stockCount) {
        this.stockCount = stockCount;
        return this;
    }

    /**
     * 获取库存数量
     *
     * @return num - 库存数量
     */
    public Integer getNum() {
        return num;
    }

    /**
     * 设置库存数量
     *
     * @param num 库存数量
     */
    public Item setNum(Integer num) {
        this.num = num;
        return this;
    }

    /**
     * 获取商品条形码
     *
     * @return barcode - 商品条形码
     */
    public String getBarcode() {
        return barcode;
    }

    /**
     * 设置商品条形码
     *
     * @param barcode 商品条形码
     */
    public Item setBarcode(String barcode) {
        this.barcode = barcode;
        return this;
    }

    /**
     * 获取商品图片
     *
     * @return image - 商品图片
     */
    public String getImage() {
        return image;
    }

    /**
     * 设置商品图片
     *
     * @param image 商品图片
     */
    public Item setImage(String image) {
        this.image = image;
        return this;
    }

    /**
     * 获取所属类目，叶子类目
     *
     * @return category_id - 所属类目，叶子类目
     */
    public Long getCategoryId() {
        return categoryId;
    }

    /**
     * 设置所属类目，叶子类目
     *
     * @param categoryId 所属类目，叶子类目
     */
    public Item setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
        return this;
    }

    /**
     * 获取商品状态，1-正常，2-下架，3-删除
     *
     * @return status - 商品状态，1-正常，2-下架，3-删除
     */
    public String getStatus() {
        return status;
    }

    /**
     * 设置商品状态，1-正常，2-下架，3-删除
     *
     * @param status 商品状态，1-正常，2-下架，3-删除
     */
    public Item setStatus(String status) {
        this.status = status;
        return this;
    }

    /**
     * 获取创建时间
     *
     * @return create_time - 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置创建时间
     *
     * @param createTime 创建时间
     */
    public Item setCreateTime(Date createTime) {
        this.createTime = createTime;
        return this;
    }

    /**
     * 获取更新时间
     *
     * @return update_time - 更新时间
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 设置更新时间
     *
     * @param updateTime 更新时间
     */
    public Item setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
        return this;
    }

    /**
     * @return item_sn
     */
    public String getItemSn() {
        return itemSn;
    }

    /**
     * @param itemSn
     */
    public Item setItemSn(String itemSn) {
        this.itemSn = itemSn;
        return this;
    }

    /**
     * @return cost_pirce
     */
    public BigDecimal getCostPirce() {
        return costPirce;
    }

    /**
     * @param costPirce
     */
    public Item setCostPirce(BigDecimal costPirce) {
        this.costPirce = costPirce;
        return this;
    }

    /**
     * @return market_price
     */
    public BigDecimal getMarketPrice() {
        return marketPrice;
    }

    /**
     * @param marketPrice
     */
    public Item setMarketPrice(BigDecimal marketPrice) {
        this.marketPrice = marketPrice;
        return this;
    }

    /**
     * @return is_default
     */
    public String getIsDefault() {
        return isDefault;
    }

    /**
     * @param isDefault
     */
    public Item setIsDefault(String isDefault) {
        this.isDefault = isDefault;
        return this;
    }

    /**
     * @return goods_id
     */
    public Long getGoodsId() {
        return goodsId;
    }

    /**
     * @param goodsId
     */
    public Item setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
        return this;
    }

    /**
     * @return seller_id
     */
    public String getSellerId() {
        return sellerId;
    }

    /**
     * @param sellerId
     */
    public Item setSellerId(String sellerId) {
        this.sellerId = sellerId;
        return this;
    }

    /**
     * @return cart_thumbnail
     */
    public String getCartThumbnail() {
        return cartThumbnail;
    }

    /**
     * @param cartThumbnail
     */
    public Item setCartThumbnail(String cartThumbnail) {
        this.cartThumbnail = cartThumbnail;
        return this;
    }

    /**
     * @return category
     */
    public String getCategory() {
        return category;
    }

    /**
     * @param category
     */
    public Item setCategory(String category) {
        this.category = category;
        return this;
    }

    /**
     * @return brand
     */
    public String getBrand() {
        return brand;
    }

    /**
     * @param brand
     */
    public Item setBrand(String brand) {
        this.brand = brand;
        return this;
    }

    /**
     * @return spec
     */
    public String getSpec() {
        return spec;
    }

    /**
     * @param spec
     */
    public Item setSpec(String spec) {
        this.spec = spec;
        return this;
    }

    /**
     * @return seller
     */
    public String getSeller() {
        return seller;
    }

    /**
     * @param seller
     */
    public Item setSeller(String seller) {
        this.seller = seller;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", title=").append(title);
        sb.append(", sellPoint=").append(sellPoint);
        sb.append(", price=").append(price);
        sb.append(", stockCount=").append(stockCount);
        sb.append(", num=").append(num);
        sb.append(", barcode=").append(barcode);
        sb.append(", image=").append(image);
        sb.append(", categoryId=").append(categoryId);
        sb.append(", status=").append(status);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", itemSn=").append(itemSn);
        sb.append(", costPirce=").append(costPirce);
        sb.append(", marketPrice=").append(marketPrice);
        sb.append(", isDefault=").append(isDefault);
        sb.append(", goodsId=").append(goodsId);
        sb.append(", sellerId=").append(sellerId);
        sb.append(", cartThumbnail=").append(cartThumbnail);
        sb.append(", category=").append(category);
        sb.append(", brand=").append(brand);
        sb.append(", spec=").append(spec);
        sb.append(", seller=").append(seller);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}