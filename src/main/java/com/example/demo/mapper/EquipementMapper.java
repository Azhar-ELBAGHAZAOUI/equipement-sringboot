package com.example.demo.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.example.demo.dto.EquipementDTO;
import com.example.demo.entity.Equipement;

@Component
public class EquipementMapper {
	
	public EquipementDTO fromModel(Equipement equipement) {
		EquipementDTO equipementDTO = new EquipementDTO();
		equipementDTO.setUuid(equipement.getUuid());
		equipementDTO.setModel(equipement.getModel());
		equipementDTO.setSerialNumber(equipement.getSerialNumber());
		equipementDTO.setType(equipement.getType());
		return equipementDTO;
	}
	
	public Equipement fromDTO(EquipementDTO equipementDTO) {
		Equipement equipement = new Equipement();
		equipement.setUuid(equipementDTO.getUuid());
		equipement.setModel(equipementDTO.getModel());
		equipement.setSerialNumber(equipementDTO.getSerialNumber());
		equipement.setType(equipementDTO.getType());
		return equipement;
	}
	
	public List<EquipementDTO> fromModels(Iterable<Equipement> equipements){
		List<EquipementDTO> equipementsDTO = new ArrayList<>();
		equipements.forEach(equipement -> {
			equipementsDTO.add(fromModel(equipement));
		});
		return equipementsDTO;
	}

}
