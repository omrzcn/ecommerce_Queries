
package com.cydeo.repository;

import com.cydeo.entity.Balance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface BalanceRepository extends JpaRepository<Balance,Long> {

    //Write a native query to get top 5 max balance
    @Query(value = "select b.amount from balance b where b.amount is not null  order by b.amount desc limit 5",nativeQuery = true)
    List<BigDecimal> retrieveMaxTop5Balance();

    //Write a derived query to get all balances greater than or equal to specific balance amount
    List<Balance> findByAmountGreaterThanEqual(BigDecimal amount);

    //Write a native query to get all balances less than specific balance amount

    @Query(value = "select b from balance b where b.amount < ?1 ",nativeQuery = true)
    List<BigDecimal> retrieveBalanceLessThan(BigDecimal amount);
}
