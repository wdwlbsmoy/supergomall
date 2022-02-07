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

@Document(indexName = "mytest",type = "user")
public class UserEntity {
    @Id
    @Field(type = FieldType.Integer,store = true)
    private int id;

    @Field(type = FieldType.Text,store = true, analyzer = "ik_max_word")
    private String name;

    @Field(type = FieldType.Text,store = true, analyzer = "ik_max_word")
    private String address;

    @Field(type = FieldType.Keyword,store = true)
    private String sex;

    public int getId() {
        return id;
    }

    public UserEntity setId(int id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public UserEntity setName(String name) {
        this.name = name;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public UserEntity setAddress(String address) {
        this.address = address;
        return this;
    }

    public String getSex() {
        return sex;
    }

    public UserEntity setSex(String sex) {
        this.sex = sex;
        return this;
    }

    @Override
    public String toString() {
        return "UserEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", sex='" + sex + '\'' +
                '}';
    }
}
