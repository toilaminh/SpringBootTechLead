package com.example.demo.controller.core2;

import com.example.demo.model.dto.core2.ObjEx8;
import com.example.demo.service.core2.ServiceJV2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping({"/account/user/jv2/ex8", "/account/admin/jv2/ex8"})
public class Exercise8 {
    @Autowired
    ServiceJV2 serviceJV2;

    @PostMapping("/add")
    public ResponseEntity<String> addP(@RequestBody ObjEx8 obj) {
        serviceJV2.addProduct(obj);
        return ResponseEntity.ok("Product " + obj.getName() + " added successfully");
    }

    @GetMapping("/all")
    public ResponseEntity<HashMap<String, ObjEx8>> display() {
        return ResponseEntity.ok(serviceJV2.getAllProducts());
    }

    @GetMapping("/find")
    public ResponseEntity<String> findInfoProductBasedOnId(@RequestParam String id) {
        return serviceJV2.findInfoProductBasedOnId(id) != null ?
                ResponseEntity.ok(serviceJV2.findInfoProductBasedOnId(id).toString()) :
                ResponseEntity.ok("Product " + id + " not found");
    }

    @DeleteMapping("/remove")
    public ResponseEntity<String> removeProductBasedOnId(@RequestParam String id) {
        boolean removed = serviceJV2.removeProductBasedOnId(id);
        return removed ? ResponseEntity.ok("Product " + id + " removed successfully") :
                ResponseEntity.ok("Product " + id + " not found");
    }

    @PutMapping("/update")
    public ResponseEntity<String> updateInfoProduct(@RequestBody ObjEx8 ObjEx8) {
        boolean updated = serviceJV2.updateInfoProduct(ObjEx8);
        return updated ? ResponseEntity.ok("Product " + ObjEx8.getName() + " updated successfully") :
                ResponseEntity.ok("Product " + ObjEx8.getName() + " not found");
    }
}
