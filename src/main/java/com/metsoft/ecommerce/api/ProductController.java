package com.metsoft.ecommerce.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/products/")
public class ProductController {
    @GetMapping("getall")
    public ResponseEntity<String> getAll(){
        return ResponseEntity.ok("Selam");
    }
}
