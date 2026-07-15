package com.SellerApp.ServiceImp;

import java.util.List;

import org.springframework.stereotype.Service;

import com.SellerApp.Enitity.Product;
import com.SellerApp.Repo.ProductRepo;
import com.SellerApp.Service.SellerService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SellerServiceImp implements SellerService
{
	 private final ProductRepo _productRepo;

	@Override
	public List<Product> searchProducts(String itemName) {
		  return _productRepo.findByItemNameContainingIgnoreCase(itemName);

	}

}
