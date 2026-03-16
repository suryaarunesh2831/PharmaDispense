package com.example.pharmacy.dto.response;

public class InventoryResponseDto {


    private long InventoryID;
    private Long drugId;


    private int BatchNumber;
    private String ExpiryDate;

    private long QuantityonHand;
    private String ReorderLevel;

    public InventoryResponseDto() {

    }

    public InventoryResponseDto(long inventoryID, Long drugId, int batchNumber, String expiryDate, long quantityonHand, String reorderLevel) {
        InventoryID = inventoryID;
        this.drugId = drugId;
        BatchNumber = batchNumber;
        ExpiryDate = expiryDate;
        QuantityonHand = quantityonHand;
        ReorderLevel = reorderLevel;
    }

    public long getInventoryID() {
        return InventoryID;
    }

    public void setInventoryID(long inventoryID) {
        InventoryID = inventoryID;
    }

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
