package com.supergo.manager.controller;

import com.supergo.http.HttpResult;
import com.supergo.manager.service.BrandService;
import com.supergo.page.PageResult;
import com.supergo.pojo.Brand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Auther:xueruiheng
 * @Date:2022/1/26
 * @Description:com.supergo.manager.controller
 * @version:1.0
 */
@RestController
@RequestMapping("brand")
public class BrandController {

    @Autowired
    private BrandService brandService;

    @PostMapping("query/{page}/{rows}")
    public Object getBrandList(@RequestBody Brand brand, @PathVariable int page, @PathVariable int rows){
        //调用service查询品牌列表
        PageResult pageresult = brandService.findPage(page, rows, brand);
        return HttpResult.ok(pageresult);
    }
}
