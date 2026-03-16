package com.example.pharmacy.dto.response;

import java.util.List;

public class DrugResponseDto {
    private Long drugId;


    String genericName;


    String BrandName;


    String strength;

    String route;

    List<String> drugAlternates;





    String classification;


    String status;

    public Long getDrugId() {
        return drugId;
    }

    public void setDrugId(Long drugId) {
        this.drugId = drugId;
    }

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

    public List<String> getDrugAlternates() {
        return drugAlternates;
    }

    public void setDrugAlternates(List<String> drugAlternates) {
        this.drugAlternates = drugAlternates;
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




}
