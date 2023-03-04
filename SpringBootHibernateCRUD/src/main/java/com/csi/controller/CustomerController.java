package com.csi.controller;

import com.csi.model.Customer;
import com.csi.services.CustomerServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CustomerController {
    @Autowired
     CustomerServices customerServicesImpl;

    @PostMapping("/savedata")
    public ResponseEntity<String>saveData(@RequestBody Customer customer){
        customerServicesImpl.saveData(customer);
        return ResponseEntity.ok("Customer Data Saved Successfully");
    }
  @GetMapping("/getdatabyid/{custId}")
    public ResponseEntity<Customer>getDataById(@PathVariable int custId) {
      return ResponseEntity.ok(customerServicesImpl.getDataById(custId));
  }
  @GetMapping("/getalldata")
    public ResponseEntity<List<Customer>>getAllData(){
        return ResponseEntity.ok(customerServicesImpl.getAllData());
  }

  @PutMapping("/updatedata/{custId}")
 public ResponseEntity<String>updateData(@PathVariable int custId , @RequestBody Customer customer){
        customerServicesImpl.updateData(custId,customer);
        return ResponseEntity.ok("Customer Data Updated successfully");
  }
@DeleteMapping("/deletedatabyid/{custId}")
    public ResponseEntity<String>deleteDataById(@PathVariable int custId){
        customerServicesImpl.deleteDataById(custId);
        return ResponseEntity.ok("Customer Data Deleted Successfully");
    }
@GetMapping("/hey")
    public ResponseEntity<String>sayHello(){
        return ResponseEntity.ok("WELCOME TO FINTECH CSI");


    }

}
