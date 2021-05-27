package com.wmi.spizarnia_domowa.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Type;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Product")
public class Product {
    @Id
    @Type(type="org.hibernate.type.UUIDCharType")
    private UUID id = UUID.randomUUID();
    private String productName;
    private int quantity;
    private int autoPurchaseCount;
    private boolean autoPurchase;

    @ManyToOne
    private Measure measure;
    @ManyToOne
    private CategoryProduct categoryProduct;
    @ManyToOne
    private CategoryShopping categoryShopping;
}
