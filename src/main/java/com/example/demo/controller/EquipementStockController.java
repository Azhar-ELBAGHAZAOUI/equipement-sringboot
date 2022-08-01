package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.EquipementStockDTO;
import com.example.demo.entity.Response;
import com.example.demo.service.EquipementStockService;

@RestController
@RequestMapping(value = "/stocks")
public class EquipementStockController {
	
	@Autowired
	private EquipementStockService equipementStockService;
	
	@RequestMapping(value = "/equipement", method = RequestMethod.POST)
	public Response<?> updateEquipementsToStock(@RequestBody EquipementStockDTO equipementStockDTO) {
		return equipementStockService.updateEquipementsToStock(equipementStockDTO);
	}

}
