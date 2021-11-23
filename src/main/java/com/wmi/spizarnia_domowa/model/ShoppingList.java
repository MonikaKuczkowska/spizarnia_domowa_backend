package com.wmi.spizarnia_domowa.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Shopping_List")
public class ShoppingList {
    @Id
    @Type(type = "org.hibernate.type.UUIDCharType")
    private UUID id = UUID.randomUUID();
    private int quantityToBuy;

    @ManyToOne
    private Group group;
    @OneToOne
    private Product product;
}
