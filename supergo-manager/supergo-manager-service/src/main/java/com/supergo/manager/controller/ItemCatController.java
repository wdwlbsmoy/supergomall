package com.supergo.manager.controller;

import com.supergo.http.HttpResult;
import com.supergo.manager.service.ItemCatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther:xueruiheng
 * @Date:2022/2/3
 * @Description:com.supergo.manager.controller
 * @version:1.0
 */

@RestController
@RequestMapping("itemcat")
public class ItemCatController {

    @Autowired
    private ItemCatService itemCatService;

    @GetMapping("/cat/list")
    public HttpResult getItemCatList(){
        HttpResult httpResult = itemCatService.getItemCatList();
        return httpResult;
    }
}
