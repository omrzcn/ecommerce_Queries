
package com.cydeo;

import com.cydeo.enums.CartState;
import com.cydeo.enums.DiscountType;
import com.cydeo.repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class QueryTest implements CommandLineRunner {

    private final AddressRepository addressRepository;
    private final BalanceRepository balanceRepository;
    private final CartItemRepository cartItemRepository;
    private final CartRepository cartRepository;
    private final CategoryRepository categoryRepository;
    private final CustomerRepository customerRepository;
    private final DiscountRepository discountRepository;
    private final OrderRepository orderRepository;
    private final PaymentRepository paymentRepository;
    private final ProductRepository productRepository;


    public QueryTest(AddressRepository addressRepository, BalanceRepository balanceRepository,
                     CartItemRepository cartItemRepository, CartRepository cartRepository,
                     CategoryRepository categoryRepository, CustomerRepository customerRepository,
                     DiscountRepository discountRepository, OrderRepository orderRepository,
                     PaymentRepository paymentRepository, ProductRepository productRepository) {
        this.addressRepository = addressRepository;
        this.balanceRepository = balanceRepository;
        this.cartItemRepository = cartItemRepository;
        this.cartRepository = cartRepository;
        this.categoryRepository = categoryRepository;
        this.customerRepository = customerRepository;
        this.discountRepository = discountRepository;
        this.orderRepository = orderRepository;
        this.paymentRepository = paymentRepository;
        this.productRepository = productRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        System.out.println("=====================Address========================");
        System.out.println("findByNameStartingWith: " +addressRepository.findAllByStreetStartingWith("Utah"));
        System.out.println("findDistinct3TopByCustomer_Email: "+addressRepository.findDistinctTop3ByCustomer_Email("asturton0@list-manage.com"));
        System.out.println("retrieveAddressWithCustomerId: "+addressRepository.retrieveAddressWithCustomerId(2L));


        System.out.println("=====================Balance========================");
        System.out.println("retrieveMaxTop5Balance: "+balanceRepository.retrieveMaxTop5Balance());
        System.out.println("findByAmountGreaterThanEqual: "+balanceRepository.findByAmountGreaterThanEqual(BigDecimal.valueOf(319.22)));
        System.out.println("retrieveBalanceLessThan: "+balanceRepository.retrieveBalanceLessThan(BigDecimal.valueOf(320)));



        System.out.println("=====================CartItem========================");
        System.out.println("countBy: "+cartItemRepository.countCartItemBy());
//        System.out.println("findByCart_CartState: "+cartItemRepository.findByCartCartState(CartState.CREATED));
//        System.out.println("retrieveCartItemByCartStateAndProductName: "+cartItemRepository.retrieveCartItemByCartStateAndProductName(CartState.CREATED,"Tomatoes"));
//        System.out.println("retrieveCartItemsWithCartStateAndWithoutDiscount: "+cartItemRepository.retrieveCartItemsWithCartStateAndWithoutDiscount("CREATED"));

//
//        System.out.println("=====================Cart========================");
//        System.out.println("findByDiscountType: "+cartRepository.findByDiscount_Id(2L));
//        System.out.println("retrieveByCustomer: "+cartRepository.retrieveByCustomer(1L));
//
//        System.out.println("=====================Category========================");
////        System.out.println("findByName: "+categoryRepository.findByName("Termite Control"));
////        System.out.println("findTop3ByOOrderByNameDesc: "+categoryRepository.findTop3ByOrderByNameDesc());
//
//
//        System.out.println("=====================Customer========================");
//        System.out.println("findByUserName: "+customerRepository.findByUserName("asturton0"));
//        System.out.println("retrieveCustomerByEmail: "+customerRepository.retrieveCustomerByEmail("mokinneally6@zimbio.com"));
//
//
//
//        System.out.println("=====================Discount========================");
//        System.out.println("findByDiscountGreaterThan: "+discountRepository.findByDiscountGreaterThan(BigDecimal.valueOf(25)));
//        System.out.println("findByDiscountType: "+discountRepository.findByDiscountType(DiscountType.AMOUNT_BASED));
//        System.out.println("retrieveDiscountsBetween: "+discountRepository.retrieveDiscountsBetween(BigDecimal.valueOf(10),BigDecimal.valueOf(30)));
//
//
//
//        System.out.println("=====================Order========================");
//        System.out.println("findTop5ByTotalPriceOrderByTotalPriceDesc: "+orderRepository.findTop5ByOrderByTotalPrice());
//        System.out.println("existsOrderBy: "+orderRepository.existsOrderByCustomer_Email("asturton0@list-manage.com"));
//        System.out.println("retrieveOrdersEqualTotalPriceAndPaidPrice: "+orderRepository.retrieveOrdersEqualTotalPriceAndPaidPrice());
//
//
//        System.out.println("=====================Payment========================");
//        System.out.println("retrieveSumOfAllPayment: "+paymentRepository.retrieveSumOfAllPayment());
//        System.out.println("retrieveAverageAllPayment: "+paymentRepository.retrieveAverageAllPayment());
//
//        System.out.println("=====================Product========================");
//        System.out.println("findByName: "+productRepository.findByName("Capon - Whole"));
//        System.out.println("countByPriceGreaterThan: "+productRepository.countByPriceGreaterThan(BigDecimal.valueOf(90)));
//

    }
}
