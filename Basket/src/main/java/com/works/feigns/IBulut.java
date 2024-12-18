package com.works.feigns;

import com.works.models.BulutProductModel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "jsonbulut", url = "https://jsonbulut.com/api/")
public interface IBulut {

    @GetMapping("products/{pid}")
    BulutProductModel singleProduct(@PathVariable String pid);

}
