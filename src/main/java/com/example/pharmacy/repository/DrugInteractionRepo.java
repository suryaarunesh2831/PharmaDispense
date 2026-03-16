package com.example.pharmacy.repository;

import com.example.pharmacy.model.DrugInteraction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface DrugInteractionRepo extends JpaRepository<DrugInteraction,Long> {

    @Query("select count(*) from DrugInteraction")
    Long  findcountofrecords();


    @Query("select d.interactingdrug.drugId from DrugInteraction d where d.drug.drugId = :id")
    Long getInteractingDrug(@Param("id") Long id);



}
