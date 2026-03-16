package com.example.pharmacy.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.Date;

@Entity
public class StockTransaction {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long TransactionID;

    @ManyToOne
    @JsonManagedReference
    @JoinColumn(name="Inventory ID")
    InventoryItem inventoryItem;

    private String TransactionType;
    private long Quantity;
    private Date TransactionDate;
    private long ReferenceID;

    public long getTransactionID() {
        return TransactionID;
    }

    public void setTransactionID(long transactionID) {
        TransactionID = transactionID;
    }

    public InventoryItem getInventoryItem() {
        return inventoryItem;
    }

    public void setInventoryItem(InventoryItem inventoryItem) {
        this.inventoryItem = inventoryItem;
    }

    public String getTransactionType() {
        return TransactionType;
    }

    public void setTransactionType(String transactionType) {
        TransactionType = transactionType;
    }

    public long getQuantity() {
        return Quantity;
    }

    public void setQuantity(long quantity) {
        Quantity = quantity;
    }

    public Date getTransactionDate() {
        return TransactionDate;
    }

    public void setTransactionDate(Date transactionDate) {
        TransactionDate = transactionDate;
    }

    public long getReferenceID() {
        return ReferenceID;
    }

    public void setReferenceID(long referenceID) {
        ReferenceID = referenceID;
    }


}
