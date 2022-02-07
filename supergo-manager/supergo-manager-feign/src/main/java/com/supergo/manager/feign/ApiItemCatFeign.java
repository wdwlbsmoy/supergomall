package com.supergo.manager.feign;

import com.supergo.http.HttpResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @Auther:xueruiheng
 * @Date:2022/2/4
 * @Description:com.supergo.manager.feign
 * @version:1.0
 */

@FeignClient("SUPERGO-MANAGER")
public interface ApiItemCatFeign {
    @GetMapping("/itemcat/cat/list")
    HttpResult getItemCatList();
}
