package com.supergo.mapper;

import com.supergo.mapper.mapper.AreasMapper;
import com.supergo.mapper.pojo.Areas;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @Auther:xueruiheng
 * @Date:2022/1/25
 * @Description:PACKAGE_NAME
 * @version:1.0
 */

@RunWith(SpringRunner.class)
@SpringBootTest(classes = MapperApplication.class)
public class AreasMapperTest {

    @Autowired
    private AreasMapper areasMapper;

    @Test
    public void findById(){
        //根据主键查询
        Areas areas = areasMapper.selectByPrimaryKey(7);
        System.out.println(areas);
    }

    @Test
    public void findAll(){
        List<Areas> areas = areasMapper.selectAll();
        areas.forEach(a-> System.out.println(a));
    }

    @Test
    public void findByExample(){
        Example example = new Example(Areas.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("areaid","110107");
        List<Areas> list = areasMapper.selectByExample(example);
        list.forEach(a-> System.out.println(a));
    }

    @Test
    public void testFindListByCityId(){
        List<Areas> list = areasMapper.findListByCityId("130300");
        list.forEach(a-> System.out.println(a));
    }

    @Test
    public void testgetListByCityId(){
        List<Areas> list = areasMapper.getListByCityId("130800");
        list.forEach(a-> System.out.println(a));
    }
}
