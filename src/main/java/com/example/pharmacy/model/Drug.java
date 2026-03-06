package com.example.pharmacy.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor

public class Drug {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long drugId;


    String genericName;


    String BrandName;


    String strength;


    String route;


    String classification;


    String status;
//
//    @OneToOne
//    private POItem poitem;
//
//    @OneToOne
//    private InventoryItem inveitem;
//
//    @OneToOne
//    private PrescriptionItem pitem;
//
//    @ManyToMany
//    List<DrugInteraction> drugIntegrations;

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

//    public POItem getPoitem() {
//        return poitem;
//    }
//
//    public void setPoitem(POItem poitem) {
//        this.poitem = poitem;
//    }
//
//    public InventoryItem getInveitem() {
//        return inveitem;
//    }
//
//    public void setInveitem(InventoryItem inveitem) {
//        this.inveitem = inveitem;
//    }
//
//    public PrescriptionItem getPitem() {
//        return pitem;
//    }
//
//    public void setPitem(PrescriptionItem pitem) {
//        this.pitem = pitem;
//    }
//
//    public List<DrugInteraction> getDrugIntegrations() {
//        return drugIntegrations;
//    }
//
//    public void setDrugIntegrations(List<DrugInteraction> drugIntegrations) {
//        this.drugIntegrations = drugIntegrations;
//    }
//
//    public List<DrugInteraction> getDrugInteractions() {
//        return drugInteractions;
//    }
//
//    public void setDrugInteractions(List<DrugInteraction> drugInteractions) {
//        this.drugInteractions = drugInteractions;
//    }

    @ManyToMany
    @JoinTable(
            name="Interaction Table",
            joinColumns = @JoinColumn(name="Drug ID"),
            inverseJoinColumns = @JoinColumn(name="Interaction ID")

    )
    List<DrugInteraction>drugInteractions=new ArrayList<>();




}
