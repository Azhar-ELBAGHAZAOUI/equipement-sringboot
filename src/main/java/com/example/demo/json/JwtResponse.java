package com.example.demo.json;


import java.io.Serializable;

import lombok.Data;
@Data
public class JwtResponse implements Serializable {

	private final String token;

}