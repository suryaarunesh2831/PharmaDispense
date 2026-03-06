package com.example.pharmacy.model;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Entity
public class InventoryItem {

    @Id
    private long InventoryID;

    @OneToOne
    @JoinColumn(name="Drug ID")
    private Drug drugobj;


    private int BatchNumber;
    private Date ExpiryDate;
    private long QuantityonHand;
    private String ReorderLevel;

    @OneToOne(mappedBy = "inventoryItem")
    private StockTransaction stockt;

}
