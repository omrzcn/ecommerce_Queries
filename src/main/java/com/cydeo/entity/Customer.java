
package com.cydeo.entity;

import jakarta.persistence.Entity;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Data
public class Customer extends BaseEntity{

    private String firstName;
    private String lastName;
    private String userName;
    private String email;

}
