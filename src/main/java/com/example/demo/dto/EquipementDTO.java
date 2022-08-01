package com.example.demo.dto;

import java.util.UUID;

import lombok.Data;

@Data
public class EquipementDTO {
	private UUID uuid;
	private String type;
	private String serialNumber;
	private String model;
}
