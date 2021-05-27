package com.wmi.spizarnia_domowa.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Type;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Shopping_List")
public class ShoppingList {
    @Id
    @Type(type="org.hibernate.type.UUIDCharType")
    private UUID id = UUID.randomUUID();
    private int quantityToBuy;

    @OneToOne
    private Product product;
}
