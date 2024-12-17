package com.works.repositories;

import com.works.entities.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface ProductRepository extends JpaRepository<Product, Long> {

    Page<Product> findByTitleContainsOrDescriptionContainsAllIgnoreCase(String title, String description, Pageable pageable);

    @Query("""
            select p from Product p
            where upper(p.title) like upper(concat('%', ?1, '%')) or upper(p.description) like upper(concat('%', ?2, '%'))""")
    List<Product> titleDescSearch(String title, String description);
}
