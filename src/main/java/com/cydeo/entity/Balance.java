
package com.cydeo.entity;

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
@Data
public class Balance extends BaseEntity{

    private BigDecimal amount;

    @OneToOne
    private Customer customer;
}
