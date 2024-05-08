
package com.cydeo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Fetch;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Data
public class CartItem extends BaseEntity{

    private Integer quantity;

    @ManyToOne
    private Cart cart;

    @ManyToOne
    private Product product;
}
