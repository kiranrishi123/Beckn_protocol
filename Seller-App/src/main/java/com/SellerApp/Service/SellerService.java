package com.SellerApp.Service;

import java.util.List;

import com.SellerApp.Enitity.Product;

public interface SellerService 
{

	public List<Product> searchProducts(String itemName);

}
