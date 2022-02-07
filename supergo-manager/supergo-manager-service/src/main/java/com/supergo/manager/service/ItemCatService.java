package com.supergo.manager.service;

import com.supergo.http.HttpResult;
import com.supergo.pojo.Itemcat;
import com.supergo.service.base.BaseService;

/**
 * @Auther:xueruiheng
 * @Date:2022/2/3
 * @Description:com.supergo.manager.service
 * @version:1.0
 */
public interface ItemCatService extends BaseService<Itemcat> {

    HttpResult getItemCatList();
}
