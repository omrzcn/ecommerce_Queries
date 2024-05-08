
package com.cydeo.entity;

import com.cydeo.enums.DiscountType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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
public class Discount extends BaseEntity{

    private String name;
    private BigDecimal discount;
    @Enumerated(EnumType.STRING)
    private DiscountType discountType;
}
