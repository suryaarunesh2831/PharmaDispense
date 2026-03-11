package com.example.pharmacy.repository;

import com.example.pharmacy.model.InventoryItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface InventoryItemRepo extends JpaRepository<InventoryItem,Long> {

    @Query("select ii from InventoryItem ii where ii.QuantityonHand < 30")
    List<InventoryItem> findItemsNeedingReorder();

    @Query("select ii.QuantityonHand from InventoryItem ii where ii.drugobj.drugId = :drugid")
    Optional<Long> finddrugquantitybasedonId(@Param("drugid") Long drugid);


}
