package com.example.pharmacy.repository;

import com.example.pharmacy.model.DrugInteraction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface DrugInteractionRepo extends JpaRepository<DrugInteraction,Long> {

    @Query("select count(*) from DrugInteraction")
    Long  findcountofrecords();

}
