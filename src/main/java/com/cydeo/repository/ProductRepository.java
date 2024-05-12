
package com.cydeo.repository;

import com.cydeo.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {

    //Write a derived query to get product by specific name
    List<Product> findByName(String name);

    //Write a derived query to get the count of products that have a price greater than specific amount
    Integer countByPriceGreaterThan(BigDecimal price);

}
