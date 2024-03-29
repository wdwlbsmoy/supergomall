package com.supergo.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.io.Serializable;
import java.util.List;

@ApiModel(value="com.supergo.pojo.Itemcat")
@Table(name = "tb_item_cat")
public class Itemcat implements Serializable {
    /**
     * 类目ID
     */
    @Id
    @ApiModelProperty(value="id类目ID")
    private Long id;

    /**
     * 父类目ID=0时，代表的是一级的类目
     */
    @Column(name = "parent_id")
    @ApiModelProperty(value="parentId父类目ID=0时，代表的是一级的类目")
    private Long parentId;

    /**
     * 类目名称
     */
    @ApiModelProperty(value="name类目名称")
    private String name;

    /**
     * 类型id
     */
    @Column(name = "type_id")
    @ApiModelProperty(value="typeId类型id")
    private Long typeId;

    private static final long serialVersionUID = 1L;

    //自定义的属性必须使用@Transient注解标注
    @Transient
    private List<Itemcat> children;

    public List<Itemcat> getChildren() {
        return children;
    }

    public void setChildren(List<Itemcat> children) {
        this.children = children;
    }

    public Itemcat(Long id, Long parentId, String name, Long typeId) {
        this.id = id;
        this.parentId = parentId;
        this.name = name;
        this.typeId = typeId;
    }

    public Itemcat() {
        super();
    }

    /**
     * 获取类目ID
     *
     * @return id - 类目ID
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置类目ID
     *
     * @param id 类目ID
     */
    public Itemcat setId(Long id) {
        this.id = id;
        return this;
    }

    /**
     * 获取父类目ID=0时，代表的是一级的类目
     *
     * @return parent_id - 父类目ID=0时，代表的是一级的类目
     */
    public Long getParentId() {
        return parentId;
    }

    /**
     * 设置父类目ID=0时，代表的是一级的类目
     *
     * @param parentId 父类目ID=0时，代表的是一级的类目
     */
    public Itemcat setParentId(Long parentId) {
        this.parentId = parentId;
        return this;
    }

    /**
     * 获取类目名称
     *
     * @return name - 类目名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置类目名称
     *
     * @param name 类目名称
     */
    public Itemcat setName(String name) {
        this.name = name;
        return this;
    }

    /**
     * 获取类型id
     *
     * @return type_id - 类型id
     */
    public Long getTypeId() {
        return typeId;
    }

    /**
     * 设置类型id
     *
     * @param typeId 类型id
     */
    public Itemcat setTypeId(Long typeId) {
        this.typeId = typeId;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", parentId=").append(parentId);
        sb.append(", name=").append(name);
        sb.append(", typeId=").append(typeId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}