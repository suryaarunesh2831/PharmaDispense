package com.example.pharmacy.dto.request;

import com.example.pharmacy.model.Drug;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

public class InventoryItemRequestDto {




    private Long drugId;


    private int BatchNumber;
    private String ExpiryDate;

    private long QuantityonHand;
    private String ReorderLevel;

    public Long getDrugId() {
        return drugId;
    }

    public void setDrugId(Long drugId) {
        this.drugId = drugId;
    }

    public int getBatchNumber() {
        return BatchNumber;
    }

    public void setBatchNumber(int batchNumber) {
        BatchNumber = batchNumber;
    }

    public String getExpiryDate() {
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
}
