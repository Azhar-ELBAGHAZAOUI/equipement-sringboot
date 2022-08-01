package com.example.demo.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Equipement;

@Repository
public interface EquipementRepository extends CrudRepository<Equipement, Long>{
	
	public List<Equipement> findByUuid(UUID uuid);

}
