package com.wmi.spizarnia_domowa.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Expiration_Date")
public class ExpirationDate {
    @Id
    @Type(type="org.hibernate.type.UUIDCharType")
    private UUID id = UUID.randomUUID();
    private LocalDate date;
    private int remainderDays;
    private String note;
}

