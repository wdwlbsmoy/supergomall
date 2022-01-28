package com.supergo.manager.controller;

import com.supergo.http.HttpResult;
import com.supergo.manager.feign.ApiBrandFeign;
import com.supergo.pojo.Brand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Auther:xueruiheng
 * @Date:2022/1/28
 * @Description:com.supergo.manager.controller
 * @version:1.0
 */

@RestController
@RequestMapping("brand")
public class BrandController {

    @Autowired
    private ApiBrandFeign brandFeign;

    @PostMapping("query/{page}/{rows}")
    public HttpResult getBrandList(@RequestBody Brand brand, @PathVariable int page, @PathVariable int rows){
        HttpResult brandList = brandFeign.getBrandList(brand, page, rows);
        return brandList;
    }
}
