package com.example.botnari_shop.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "roles")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Role{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String roleName;
	
	public Role(String roleName) {
		super();
		this.roleName = roleName;
	}
	
	
}
