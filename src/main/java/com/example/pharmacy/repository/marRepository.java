package com.example.pharmacy.repository;

import com.example.pharmacy.model.MAR;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface marRepository extends JpaRepository<MAR,Integer> {
}
