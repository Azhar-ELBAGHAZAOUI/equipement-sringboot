package com.example.demo.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.dto.EquipementStockDTO;
import com.example.demo.entity.EquipementStock;
import com.example.demo.repository.EquipementRepository;
import com.example.demo.repository.StockRepository;

@Component
public class EquipementStockMapper {

	@Autowired
	private EquipementRepository equipementRepository;
	@Autowired
	private StockRepository stockRepository;
	
	public EquipementStock fromDTO(EquipementStockDTO equipementStockDTO) {
		EquipementStock equipementStock = new EquipementStock();
		equipementStock.setEquipement(equipementRepository.findById(equipementStockDTO.getEquipementId()).get());
		equipementStock.setStock(stockRepository.findById(equipementStockDTO.getStockId()).get());
		equipementStock.setQuantity(equipementStockDTO.getQuantity());
		return equipementStock;
	}
}
