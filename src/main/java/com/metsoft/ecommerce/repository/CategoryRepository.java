package com.metsoft.ecommerce.repository;


import com.metsoft.ecommerce.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository  extends JpaRepository<Category,Integer> {
}
