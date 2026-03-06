package com.example.pharmacy.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

import java.util.Date;

@Entity
public class StockTransaction {

    @Id
    private long TransactionID;

    @OneToOne
    @JoinColumn(name="Inventory ID")
    InventoryItem inventoryItem;

    private String TransactionType;
    private long Quantity;
    private Date TransactionDate;
    private long ReferenceID;

}
