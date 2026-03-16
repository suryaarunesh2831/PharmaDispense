package com.example.pharmacy.repository;

import com.example.pharmacy.model.Drug;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DrugRepo extends JpaRepository<Drug,Long> {

    @Query("select d from Drug d order by d.drugId")
    List<Drug> sortDrug();

    @Query("select d.drugAlternates from Drug d where d.drugId = :id")
    List<String> getDrugAlternatesByDrugId(@Param("id") Long id);

}
