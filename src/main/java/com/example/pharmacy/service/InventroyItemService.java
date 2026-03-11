package com.example.pharmacy.service;

import com.example.pharmacy.model.Drug;
import com.example.pharmacy.model.InventoryItem;
import com.example.pharmacy.repository.DrugRepo;
import com.example.pharmacy.repository.InventoryItemRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Service
public class InventroyItemService {

    @Autowired
    InventoryItemRepo inventoryItemRepo;

    @Autowired
    DrugRepo drugRepo;



    public InventoryItem createInventoryItem( InventoryItem inventoryitem)
    {
        Drug drug=drugRepo.findById(inventoryitem.getDrugobj().getDrugId()).get();

        inventoryitem.setDrugobj(drug);



        return inventoryItemRepo.save(inventoryitem);



    }

    public InventoryItem getInventoryItemById(Long id)
    {
        return inventoryItemRepo.findById(id).get();
    }

    public List<InventoryItem> getAll()
    {
        return inventoryItemRepo.findAll();
    }

    public InventoryItem updateInventoryItem(@PathVariable Long id,@RequestBody InventoryItem request)
    {
        InventoryItem existing=inventoryItemRepo.findById(id).get();

        existing.setBatchNumber(request.getBatchNumber());
        existing.setExpiryDate(request.getExpiryDate());
        existing.setReorderLevel(request.getReorderLevel());
        existing.setQuantityonHand(request.getQuantityonHand());

        Drug drug=drugRepo.findById(request.getDrugobj().getDrugId()).get();

        existing.setDrugobj(drug);

        return inventoryItemRepo.save(existing);


    }

    public String deleteInventoryItemById(@PathVariable Long id)
    {


          inventoryItemRepo.deleteById(id);
          return "The Inventory Item has been successfully deleted";
    }

    public String deleteAll()
    {


         inventoryItemRepo.deleteAll();

         return "The InventoryItem table  has been successfully cleared";
    }
    public List<InventoryItem>reorderdrugs()
    {
        return inventoryItemRepo.findItemsNeedingReorder();
    }
    public Optional<Long> findquantitybasedonDrug(Long drugId)
    {
        return inventoryItemRepo.finddrugquantitybasedonId(drugId);
    }


}
