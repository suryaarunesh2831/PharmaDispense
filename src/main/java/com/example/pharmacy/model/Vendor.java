package com.example.pharmacy.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Vendor {

    @Id
    private long VendorID;

    private String Name;
    private long ContactInfo;
    private long Rating;
    private String Status;

    @OneToMany(mappedBy = "vendor")
    private List<PurchaseOrder> purchaseOrders = new ArrayList<>();


}
