package com.example.pharmacy.controller;


import com.example.pharmacy.model.Vendor;
import com.example.pharmacy.service.VendorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vendor")
public class VendorController {
    @Autowired
    public VendorService vendorService;

    @PostMapping("/post")
    public Vendor createVendor(@RequestBody Vendor vendor){
        return vendorService.createVendor(vendor);
    }

    @PutMapping("/update/{id}")
    public Vendor updateVendor(@PathVariable Long id, @RequestBody Vendor vendor){
        return vendorService.updateVendor(id,vendor);
    }

    @GetMapping("/get/All")
    public List<Vendor> getAllVendors(){
        return vendorService.getAllVendors();
    }

    @GetMapping("/get/{id}")
    public Vendor getVendorById(@PathVariable Long id){
        return vendorService.getVendorById(id);
    }

    @DeleteMapping("/delete/All")
    public void deleteAllVendor(){
        vendorService.deleteAllVendor();
    }

    @DeleteMapping("/delete/{id}")
    public void deleteVendorById(@PathVariable Long id){
        vendorService.deleteVendorById(id);
    }



}
