package com.example.pharmacy.model;

import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "drugId"
)
public class Drug {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long drugId;


    String genericName;


    String BrandName;


    String strength;


    String route;

    public List<DrugInteraction> getListofinteractions() {
        return listofinteractions;
    }

    public void setListofinteractions(List<DrugInteraction> listofinteractions) {
        this.listofinteractions = listofinteractions;
    }

    public List<DrugInteraction> getInteractionwith() {
        return interactionwith;
    }

    public void setInteractionwith(List<DrugInteraction> interactionwith) {
        this.interactionwith = interactionwith;
    }

    String classification;


    String status;
//
//    @OneToOne
//    private POItem poitem;
//
//    @OneToOne(cascade = CascadeType.ALL)
//    @JsonBackReference
//    private InventoryItem inveitem;
//
//    @OneToOne
//    private PrescriptionItem pitem;
//


    @OneToMany(mappedBy = "drug")
    private List<DrugInteraction>listofinteractions;//in the case where drug is the main drug

    @OneToMany(mappedBy = "interactingdrug")
    private List<DrugInteraction>interactionwith; //in the case where drug is the interactingdrug

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







}
