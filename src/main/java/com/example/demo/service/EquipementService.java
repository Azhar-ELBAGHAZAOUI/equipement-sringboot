package com.example.demo.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.EquipementDTO;
import com.example.demo.entity.Equipement;
import com.example.demo.entity.Response;
import com.example.demo.mapper.EquipementMapper;
import com.example.demo.repository.EquipementRepository;

@Service
public class EquipementService {
	
	@Autowired
	private EquipementMapper equipementMapper;

	@Autowired
	private EquipementRepository equipementRepository;
	private Equipement equipementUpdated;

	public Response<EquipementDTO> saveEquipement(Equipement equipement) {
		Response<EquipementDTO> response = new Response<EquipementDTO>();
		try {
			response.setError(false);
			response.setMessage(equipementMapper.fromModel(equipementRepository.save(equipement)));
			return response;
		} catch(Throwable e) {
			response.setError(true);
			response.setErrorMessage("Error invoke :" + e.getMessage());
			return response;
		}
	}

	public Response<Iterable<EquipementDTO>> getEquipementByUuid(UUID uuid) {
		Response<Iterable<EquipementDTO>> response = new Response<Iterable<EquipementDTO>>();
		try {
			response.setError(false);
			response.setMessage(equipementMapper.fromModels(equipementRepository.findByUuid(uuid)));
			return response;
		} catch(Throwable e) {
			response.setError(true);
			response.setErrorMessage("Error invoke :" + e.getMessage());
			return response;
		}
	}

	public Response<Iterable<EquipementDTO>> getAllEquipements() {
		Response<Iterable<EquipementDTO>> response = new Response<Iterable<EquipementDTO>>();
		try {
			response.setError(false);
			response.setMessage(equipementMapper.fromModels(equipementRepository.findAll()));
			return response;
		} catch (Throwable e) {
			response.setError(true);
			response.setErrorMessage("Error invoke :" + e.getMessage());
			return response;		}
	}

	public Response<EquipementDTO> updateEquipement(UUID uuid, Equipement equipement) {
		Response<EquipementDTO> response = new Response<EquipementDTO>();
		try {
			Equipement equipementFromDb = equipementRepository.findByUuid(uuid).get(0);
			equipementFromDb.setType(equipement.getType());
			equipementFromDb.setSerialNumber(equipement.getSerialNumber());
			equipementFromDb.setModel(equipement.getModel());
			equipementUpdated = equipementRepository.save(equipementFromDb);
			response.setMessage(equipementMapper.fromModel(equipementUpdated));
			response.setError(false);
			return response;
		} catch (Throwable e) {
			response.setError(true);
			response.setErrorMessage("Error invoke :" + e.getMessage());
			return response;
		}

	}

	public Response<String> deleteEquipement(UUID uuid) {
		Response<String> response = new Response<String>();
		try {
			long id = equipementRepository.findByUuid(uuid).get(0).getId();
			equipementRepository.deleteById(id);
			response.setError(false);
			response.setMessage("Delete equipement with uuid " + uuid);
			return response;
		} catch (Throwable e) {
			response.setError(true);
			response.setErrorMessage("Error invoke :" + e.getMessage());
			return response;
		}
	}

}
