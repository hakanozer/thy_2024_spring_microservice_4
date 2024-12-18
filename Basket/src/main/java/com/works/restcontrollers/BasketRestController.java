package com.works.restcontrollers;

import com.works.models.ProductModel;
import com.works.services.BasketService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("basket")
public class BasketRestController {

    final BasketService basketService;

    @GetMapping("data")
    public Map<String,Object> data(){
        Map<String,Object> hm = new LinkedHashMap<>();
        hm.put("bid",100);
        hm.put("status", true);
        return hm;
    }

    @GetMapping("productSearch")
    public ProductModel productSearch(@RequestParam String q ){
        return basketService.productSearch(q);
    }

}
