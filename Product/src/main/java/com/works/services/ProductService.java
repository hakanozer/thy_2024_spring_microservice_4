package com.works.services;

import com.works.entities.Product;
import com.works.repositories.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    final ProductRepository productRepository;
    final CacheManager cacheManager;

    public Product save(Product product) {
        productRepository.save(product);
        cacheManager.getCache("product").clear();
        return product;
    }

    public List<Product> saveAll(List<Product> products) {
        return productRepository.saveAll(products);
    }


    @Cacheable("product")
    public Page<Product> findAll( int page, int size ) {
        int currentSize = size;
        int currentPage = page;

        if (currentPage < 0) {
            currentPage = 0;
        }
        if (currentSize > 50 || currentSize < 0) {
            currentSize = 10;
        }
        Pageable pageable = PageRequest.of(currentPage, currentSize);
        return productRepository.findAll(pageable);
    }

    public Page<Product> search( String q, int page ) {
        Pageable pageable = PageRequest.of(page, 10);
        Page<Product> products = productRepository.findByTitleContainsOrDescriptionContainsAllIgnoreCase(q,q,pageable);
        return products;
    }


}
