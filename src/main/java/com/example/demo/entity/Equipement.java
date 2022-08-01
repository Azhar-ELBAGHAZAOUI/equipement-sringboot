package com.example.demo.entity;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Equipement {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@GeneratedValue(generator = "uuid2")
	@GenericGenerator(name = "uuid2", strategy = "uuid2")
	@Column(name = "uuid", columnDefinition = "BINARY(16)")
	private UUID uuid;
	private String type;
	private String serialNumber;
	private String model;

    @OneToMany(mappedBy = "equipement", cascade = CascadeType.ALL)
    @JsonIgnoreProperties("equipement")
    private Set<EquipementStock> equipementStocks = new HashSet<>();


	public Equipement() {
		super();
		this.uuid = UUID.randomUUID();
	}

}
