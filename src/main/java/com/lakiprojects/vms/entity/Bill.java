package com.lakiprojects.vms.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "Bill")

public class Bill {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Bill_Id",length = 100)
    private int billId;

    @OneToMany(mappedBy = "bill")
    private Set<BillDetail> billDetails;

    @Column(name = "date", length = 20)
    @Temporal(TemporalType.DATE)
    private Date date;

    @Column(name = "total_price",length = 100)
    private double totalPrice;

    @ManyToOne
    @JoinColumn(name = "Customer_Id",nullable = false)
    private Customer customer;

    public Bill(Customer referenceById, double totalPrice, Date date) {
    }
}
