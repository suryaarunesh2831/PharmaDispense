package com.example.pharmacy.model;

import com.example.pharmacy.model.PurchaseOrder;
import jakarta.persistence.*;

@Entity
public class POItem {

    @Id
    private long POItemID;

    @ManyToOne
    @JoinColumn(name="PO ID")
    private PurchaseOrder purchaseOrder;

    // Many to Many
    private long DrugID;
    private long OrderedQty;
    private long ReceivedQty;


    @OneToOne
    @JoinColumn(name="Drug ID")
    private Drug drug;
}
