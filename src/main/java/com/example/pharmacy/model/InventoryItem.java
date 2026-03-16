package com.example.pharmacy.model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Entity
public class InventoryItem {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long InventoryID;

    @OneToOne
    @JoinColumn(name="Drug ID")
    private Drug drugobj;


    private int BatchNumber;
    private String ExpiryDate;

    private long QuantityonHand;
    private String ReorderLevel;

    public long getInventoryID() {
        return InventoryID;
    }

    public void setInventoryID(long inventoryID) {
        InventoryID = inventoryID;
    }

    public Drug getDrugobj() {
        return drugobj;
    }

    public void setDrugobj(Drug drugobj) {
        this.drugobj = drugobj;
    }

    public int getBatchNumber() {
        return BatchNumber;
    }

    public void setBatchNumber(int batchNumber) {
        BatchNumber = batchNumber;
    }

    public String  getExpiryDate() {
        return ExpiryDate;
    }

    public void setExpiryDate(String expiryDate) {
        ExpiryDate = expiryDate;
    }

    public long getQuantityonHand() {
        return QuantityonHand;
    }

    public void setQuantityonHand(long quantityonHand) {
        QuantityonHand = quantityonHand;
    }

    public String getReorderLevel() {
        return ReorderLevel;
    }

    public void setReorderLevel(String reorderLevel) {
        ReorderLevel = reorderLevel;
    }

    public List<StockTransaction> getStockt() {
        return stockt;
    }

    public void setStockt(List<StockTransaction> stockt) {
        this.stockt = stockt;
    }

    @OneToMany(mappedBy = "inventoryItem")
    @JsonBackReference
    private List<StockTransaction> stockt;

}
