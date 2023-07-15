package com.example.groceryApp.Repository;

import com.example.groceryApp.Model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
