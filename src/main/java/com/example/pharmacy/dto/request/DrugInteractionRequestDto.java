package com.example.pharmacy.dto.request;

import com.example.pharmacy.model.Drug;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

public class DrugInteractionRequestDto {

    private Long drug_id;
    private Long interactingdrug_id;

    private String Severity;

    private String Description;

    public Long getDrug_id() {
        return drug_id;
    }

    public void setDrug_id(Long drug_id) {
        this.drug_id = drug_id;
    }

    public Long getInteractingdrug_id() {
        return interactingdrug_id;
    }

    public void setInteractingdrug_id(Long interactingdrug_id) {
        this.interactingdrug_id = interactingdrug_id;
    }

    public String getSeverity() {
        return Severity;
    }

    public void setSeverity(String severity) {
        Severity = severity;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }
}
