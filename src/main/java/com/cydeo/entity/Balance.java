
package com.cydeo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Balance extends BaseEntity{
    @Column(precision = 19,scale = 2)
    private BigDecimal amount;

    @OneToOne
    private Customer customer;

    @Override
    public String toString() {
        return "Balance{" +
                "amount=" + amount +
                '}';
    }
}
