
package com.cydeo.repository;

import com.cydeo.entity.Cart;
import com.cydeo.enums.CartState;
import com.cydeo.enums.DiscountType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartRepository extends JpaRepository<Cart,Long> {

    //Write a derived query to get all cart by specific discount type
    List<Cart> findByDiscount_Id(Long id);

    //Write a JPQL query to get all cart by customer
    @Query("select c from Cart c where c.customer.id=?1 ")
    List<Cart> retrieveByCustomer(Long id);
}
