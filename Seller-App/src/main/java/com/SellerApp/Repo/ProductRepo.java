package com.SellerApp.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.SellerApp.Enitity.Product;

public interface ProductRepo  extends JpaRepository<Product,String >
{
	List<Product> findByItemNameContainingIgnoreCase(String itemName);

}
