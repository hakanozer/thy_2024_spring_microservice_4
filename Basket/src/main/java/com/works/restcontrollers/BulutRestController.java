package com.works.restcontrollers;

import com.works.feigns.IBulut;
import com.works.models.BulutProductModel;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("basket")
public class BulutRestController {

    final IBulut iBulut;

    @GetMapping("bulutProduct")
    public BulutProductModel getBulutProduct(@RequestParam(defaultValue = "1") String pid){
        return iBulut.singleProduct(pid);
    }


}
