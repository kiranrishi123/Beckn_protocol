package com.SellerApp.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.SellerApp.Enitity.Product;
import com.SellerApp.Service.SellerService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/seller")
@RequiredArgsConstructor
public class SellerController
{
//	@Autowired
	private final SellerService _sellerService;
	
	@GetMapping("/search/{itemName}")
    public List<Product> searchProducts(@PathVariable String itemName) {

        return _sellerService.searchProducts(itemName);

    }


}
