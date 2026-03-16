package com.example.pharmacy.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Vendor {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long VendorID;

    private String Name;
    private long ContactInfo;
    private long Rating;
    private String Status;

    @OneToMany(mappedBy = "vendor")
    private List<PurchaseOrder> purchaseOrders = new ArrayList<>();

    public long getVendorID() {
        return VendorID;
    }

    public void setVendorID(long vendorID) {
        VendorID = vendorID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public long getContactInfo() {
        return ContactInfo;
    }

    public void setContactInfo(long contactInfo) {
        ContactInfo = contactInfo;
    }

    public long getRating() {
        return Rating;
    }

    public void setRating(long rating) {
        Rating = rating;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public List<PurchaseOrder> getPurchaseOrders() {
        return purchaseOrders;
    }

    public void setPurchaseOrders(List<PurchaseOrder> purchaseOrders) {
        this.purchaseOrders = purchaseOrders;
    }


}
