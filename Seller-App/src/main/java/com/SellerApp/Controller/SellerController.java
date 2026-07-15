package com.SellerApp.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.SellerApp.Enitity.Product;
import com.SellerApp.Service.SellerService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/seller")
@RequiredArgsConstructor
public class SellerController
{

	private final SellerService _sellerService;
	
	@GetMapping("/v1/getProductByName")
    public List<Product> searchProducts(@RequestParam String itemName) {

        return _sellerService.searchProducts(itemName);

    }


}
