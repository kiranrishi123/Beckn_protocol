package com.BeckenGateway.DTO;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Provider 
{
	private String id;

    private Descriptor descriptor;

    private List<Item> items;

}
