package com.codeup.codeupspringblog.repositories;

import com.codeup.codeupspringblog.Model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
