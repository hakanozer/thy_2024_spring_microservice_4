package com.works.services;

import com.works.feigns.IProduct;
import com.works.models.ProductModel;
import lombok.RequiredArgsConstructor;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BasketService {

    final DiscoveryClient discoveryClient;
    final IProduct iProduct;

    public ProductModel productSearch(String q) {
        /*
        List<ServiceInstance> instances = discoveryClient.getInstances("product");
        if (instances != null || !instances.isEmpty()) {
            ServiceInstance serviceInstance = instances.get(0);
            String uri = serviceInstance.getUri().toString();
            uri = uri + "/product/search?q="+q;
            RestTemplate restTemplate = new RestTemplate();
            ResponseEntity<ProductModel> response = restTemplate.getForEntity(uri, ProductModel.class);
            return response.getBody();
        }
        return null;
         */
        return iProduct.search(q);
    }

}
