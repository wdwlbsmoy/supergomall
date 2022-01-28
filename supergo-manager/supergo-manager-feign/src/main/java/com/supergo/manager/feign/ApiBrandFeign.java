package com.supergo.manager.feign;

import com.supergo.http.HttpResult;
import com.supergo.pojo.Brand;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @Auther:xueruiheng
 * @Date:2022/1/28
 * @Description:com.supergo.manager.feign
 * @version:1.0
 */

@FeignClient(name = "supergo-manager")
public interface ApiBrandFeign {

    @PostMapping("/brand/query/{page}/{rows}")
    HttpResult getBrandList(@RequestBody Brand brand, @PathVariable("page") int page, @PathVariable("rows") int rows);

}
