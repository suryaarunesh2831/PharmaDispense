package com.example.pharmacy.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class PurchaseOrder {

    @Id
    private long POID;

    // ManyToOne

    @OneToMany
    List<POItem> item=new ArrayList<>();

    @ManyToOne
    @JoinColumn(name="Vendor ID")
    private Vendor vendor;

    private Date orderDate;
    private Date ExpectedDate;
    private String Status;





}
