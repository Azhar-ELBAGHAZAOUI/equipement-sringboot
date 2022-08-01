package com.example.demo.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Equipement;
import com.example.demo.entity.Response;
import com.example.demo.service.EquipementService;

@RestController
@RequestMapping(value = "/equipements")
public class EquipementController {
	
	@Autowired
	private EquipementService equipementService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public Response<?> getAllEquipement(){
		return equipementService.getAllEquipements();
	}
	
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public Response<?> saveEquipement(@RequestBody Equipement equipement) {
		return equipementService.saveEquipement(equipement);
	}
	
	@RequestMapping(value = "/{uuid}", method = RequestMethod.GET)
	public Response<?> getEquipementById(@PathVariable("uuid") UUID uuid) { 
		return equipementService.getEquipementByUuid(uuid);
    }
	
	@RequestMapping(value = "/{uuid}", method = RequestMethod.PUT)
	public Response<?> updateEquipement(@PathVariable("uuid") UUID uuid, @RequestBody Equipement equipement) {
		return equipementService.updateEquipement(uuid, equipement);
	}
	
	@RequestMapping(value = "/{uuid}", method = RequestMethod.DELETE)
	public Response<?> deleteEquipementByUuid(@PathVariable("uuid") UUID uuid) { 
        return equipementService.deleteEquipement(uuid);
    }
	
	

}
