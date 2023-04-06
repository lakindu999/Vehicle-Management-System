package com.lakiprojects.vms.entity;

import com.vladmihalcea.hibernate.type.json.JsonType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

import javax.persistence.*;
import java.util.ArrayList;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "Customer")
@TypeDefs({
        @TypeDef(name = "json", typeClass = JsonType.class)
})

public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Customer_Id",length = 100)
    private int customerID;

    @Column(name = "Customer_Name",length = 100,nullable = false)
    private String customerName;

    @Column(name = "Customer_Address",length = 100,nullable = false)
    private String customerAddress;

    @Type(type = "json")
    @Column(name = "contact_numbers",columnDefinition = "json")
    private ArrayList contactNumber;

    @Column(name = "active_status", columnDefinition = "TINYINT default 1")
    private boolean activeStatus;
}
