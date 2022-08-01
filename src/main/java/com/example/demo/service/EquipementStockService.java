package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.EquipementStockDTO;
import com.example.demo.entity.EquipementStock;
import com.example.demo.entity.Response;
import com.example.demo.mapper.EquipementStockMapper;
import com.example.demo.repository.EquipementStockRepository;

@Service
public class EquipementStockService {
	@Autowired
	private EquipementStockMapper equipementStockMapper;
	@Autowired
	private EquipementStockRepository equipementstockRepository;

	public Response<?> updateEquipementsToStock(EquipementStockDTO equipementStockDTO) {
		
		Response<EquipementStock> response = new Response<EquipementStock>();
		try {
			response.setError(false);
			EquipementStock equipementStock = equipementStockMapper.fromDTO(equipementStockDTO);
			equipementStock = equipementstockRepository.save(equipementStock);
			response.setMessage(equipementStock);
			return response;
		} catch(Throwable e) {
			response.setError(true);
			response.setErrorMessage("Error invoke :" + e.getMessage());
			return response;
		}
	}

}
