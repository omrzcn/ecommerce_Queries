
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
        System.out.println("findDistinct3TopByCustomer_Email: "+addressRepository.findDistinctTop3ByCustomer_Email("rmcroberts1o@theglobeandmail.com"));
        System.out.println("retrieveAddressWithCustomerId: "+addressRepository.retrieveAddressWithCustomerId(2L));


        System.out.println("=====================Balance========================");
        System.out.println("retrieveMaxTop5Balance: "+balanceRepository.retrieveMaxTop5Balance());
        System.out.println("findByAmountGreaterThanEqual: "+balanceRepository.findByAmountGreaterThanEqual(BigDecimal.valueOf(319.22)));
        System.out.println("retrieveBalanceLessThan: "+balanceRepository.retrieveBalanceLessThan(BigDecimal.valueOf(320)));



        System.out.println("=====================CartItem========================");
        System.out.println("countBy: "+cartItemRepository.countBy());
//        System.out.println("findByCart_CartState: "+cartItemRepository.findCartItemByCart_CartState(CartState.CREATED));
//        System.out.println("retrieveCartItemByCartStateAndProductName: "+cartItemRepository.retrieveCartItemByCartStateAndProductName(CartState.CREATED,"Tomatoes"));


        System.out.println("=====================Cart========================");
        System.out.println("findByDiscountType: "+cartRepository.findByDiscountDiscountType(DiscountType.AMOUNT_BASED));
        System.out.println("retrieveByCustomer: "+cartRepository.retrieveByCustomer());

        System.out.println("=====================Category========================");
        System.out.println("findByName: "+categoryRepository.findByName("Termite Control"));
        System.out.println("findTop3ByOOrderByNameDesc: "+categoryRepository.findTop3ByOrderByNameDesc());


    }
}
