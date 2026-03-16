package com.example.pharmacy.dto.response;

public class DrugInteractionResponseDto {

    private Long InteractionID;
    private String Severity;

    private String Description;


    private Long drug_id;
    private Long interactingdrug_id;

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

    public Long getInteractionID() {
        return InteractionID;
    }

    public void setInteractionID(Long interactionID) {
        InteractionID = interactionID;
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
