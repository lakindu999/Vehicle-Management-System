package com.lakiprojects.vms.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "Bill_Detail")
public class BillDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Bill_Detail_Id",length = 100)
    private int billDetailID;

    @ManyToOne
    @JoinColumn(name = "vehicle_Id",nullable = false)
    private Vehicle vehicle;

    @ManyToOne
    @JoinColumn(name = "bill_Id",nullable = false)
    private Bill bill;
}
