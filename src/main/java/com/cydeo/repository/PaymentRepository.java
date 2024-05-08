
package com.cydeo.repository;

import com.cydeo.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface PaymentRepository extends JpaRepository<Payment,Long> {

    //Write a native query to find the total sum of all payments made
    @Query(value = "select sum (p.paidPrice) from Payment p")
    BigDecimal retrieveSumOfAllPayment();
    //write a native query to find the average amount paid for all payments
    @Query(value = "select avg (p.paidPrice) from Payment p")
    BigDecimal retrieveAverageAllPayment();


}
