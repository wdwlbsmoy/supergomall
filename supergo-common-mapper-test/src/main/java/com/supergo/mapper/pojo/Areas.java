package com.supergo.mapper.pojo;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @Auther:xueruiheng
 * @Date:2022/1/25
 * @Description:com.supergo.mapper.pojo
 * @version:1.0
 */

@Table(name = "tb_areas")
public class Areas implements Serializable {

    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "areaid")
    private String areaid;

    @Column(name = "area")
    private String area;

    @Column(name = "cityid")
    private String cityid;

    public Integer getId() {
        return id;
    }

    public Areas setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getAreaid() {
        return areaid;
    }

    public Areas setAreaid(String areaid) {
        this.areaid = areaid;
        return this;
    }

    public String getArea() {
        return area;
    }

    public Areas setArea(String area) {
        this.area = area;
        return this;
    }

    public String getCityid() {
        return cityid;
    }

    public Areas setCityid(String cityid) {
        this.cityid = cityid;
        return this;
    }

    @Override
    public String toString() {
        return "Areas{" +
                "id=" + id +
                ", areaid='" + areaid + '\'' +
                ", area='" + area + '\'' +
                ", cityid='" + cityid + '\'' +
                '}';
    }
}
