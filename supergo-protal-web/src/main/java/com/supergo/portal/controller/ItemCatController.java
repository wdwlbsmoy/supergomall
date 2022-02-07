package com.supergo.portal.controller;

import com.supergo.http.HttpResult;
import com.supergo.manager.feign.ApiItemCatFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther:xueruiheng
 * @Date:2022/2/4
 * @Description:com.supergo.portal.controller
 * @version:1.0
 */

@RestController
@RequestMapping
public class ItemCatController {

    @Autowired
    private ApiItemCatFeign itemCatFeign;

    @GetMapping("/categorys/categorys")
    public Object getCategoryList(){
        HttpResult httpResult = itemCatFeign.getItemCatList();
        if (httpResult.getCode() == 200){
            return httpResult;
        }
        return httpResult.getMsg();
    }
}
