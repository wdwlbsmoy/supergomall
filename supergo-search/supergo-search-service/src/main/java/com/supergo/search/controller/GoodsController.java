package com.supergo.search.controller;

import com.supergo.http.HttpResult;
import com.supergo.search.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther:xueruiheng
 * @Date:2022/2/7
 * @Description:com.supergo.search.controller
 * @version:1.0
 */

@RestController
@RequestMapping
public class GoodsController {

    @Autowired
    private GoodsService goodsService;

    @GetMapping("/import")
    public HttpResult importGoods(){
        HttpResult httpResult = goodsService.importGoodsList();
        return httpResult;
    }
}
