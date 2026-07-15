package com.SellerApp.Enitity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name="product_master")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Product
{
	
	@Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String itemCode;

    private String itemName;

    private String description;

    private Double price;

    private Integer quantity;

    private String category;

    private String sellerName;

    private Boolean available;

}
