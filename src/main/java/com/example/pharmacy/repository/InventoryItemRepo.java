package com.example.pharmacy.repository;

import com.example.pharmacy.model.InventoryItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InventoryItemRepo extends JpaRepository<InventoryItem,Long> {
}
