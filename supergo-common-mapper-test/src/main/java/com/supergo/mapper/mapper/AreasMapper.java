package com.supergo.mapper.mapper;

import com.supergo.mapper.pojo.Areas;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * @Auther:xueruiheng
 * @Date:2022/1/25
 * @Description:com.supergo.mapper.mapper
 * @version:1.0
 */
public interface AreasMapper extends Mapper<Areas> {

    @Select("select * from tb_areas where cityid=#{cityId}")
    List<Areas> findListByCityId(String cityId);

    List<Areas> getListByCityId(String cityId);
}
