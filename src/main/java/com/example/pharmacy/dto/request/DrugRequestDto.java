package com.example.pharmacy.dto.request;

import jakarta.validation.constraints.NotBlank;
import java.util.List;

public class DrugRequestDto {

    private Long drugId;

    @NotBlank(message = "Generic name is required")
    String genericName;

    @NotBlank(message = "Brand name is required")
    String BrandName;

    @NotBlank(message = "Strength is required")
    String strength;

    @NotBlank(message = "Route is required")
    String route;

    List<String> drugAlternates;

    @NotBlank(message = "Classification is required")
    String classification;

    @NotBlank(message = "Status is required")
    String status;

    public String getGenericName() {
        return genericName;
    }

    public void setGenericName(String genericName) {
        this.genericName = genericName;
    }

    public String getBrandName() {
        return BrandName;
    }

    public void setBrandName(String brandName) {
        BrandName = brandName;
    }

    public String getStrength() {
        return strength;
    }

    public void setStrength(String strength) {
        this.strength = strength;
    }

    public String getRoute() {
        return route;
    }

    public void setRoute(String route) {
        this.route = route;
    }

    public String getClassification() {
        return classification;
    }

    public void setClassification(String classification) {
        this.classification = classification;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<String> getDrugAlternates() {
        return drugAlternates;
    }

    public void setDrugAlternates(List<String> drugAlternates) {
        this.drugAlternates = drugAlternates;
    }
}