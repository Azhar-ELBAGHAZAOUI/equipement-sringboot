package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.EquipementStock;

@Repository
public interface EquipementStockRepository extends CrudRepository<EquipementStock, Long>{

}
