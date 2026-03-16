package com.example.pharmacy.dto.request;

import com.example.pharmacy.model.InventoryItem;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

import java.util.Date;

public class StockTransactionRequestDto {



    private String TransactionType;
    private long Quantity;
    private Date TransactionDate;
    private long ReferenceID;



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
