package com.BeckenGateway.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto 
{
	private String id;

    private String itemCode;

    private String itemName;

    private String description;

    private Double price;

    private Integer quantity;

    private String category;
    
    private String sellerId;
    
    private String sellerName;

    private Boolean available;
    
    


}
