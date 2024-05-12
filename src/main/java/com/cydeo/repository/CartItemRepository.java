
package com.cydeo.repository;

import com.cydeo.entity.Cart;
import com.cydeo.entity.CartItem;
import com.cydeo.enums.CartState;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartItemRepository extends JpaRepository<CartItem,Long> {

    //Write a derived query to get the count of all cart items
    int countCartItemBy();

    //Write a derived query to get cart items for specific cart state
    List<CartItem> findByCartCartState(CartState cartState);

    //Write a native query to get cart items for specific cart state and product name

    @Query(value = "select c from CartItem c join Product  p on c.product.id = p.id where c.cart.cartState=:cartState and c.product.name=:name")
    List<CartItem> retrieveCartItemByCartStateAndProductName(@Param("cartState") CartState cartState, @Param("name") String name);


    //Write a native query to get cart items for specific cart state and without discount
    @Query(value = " select c from cart_item c join cart b on c.cart_id = b.id where b.discount_id is null or b.cart_state=?1",nativeQuery = true)
    List<CartItem> retrieveCartItemsWithCartStateAndWithoutDiscount(String state);
}
