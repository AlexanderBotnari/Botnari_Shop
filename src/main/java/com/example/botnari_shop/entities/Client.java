package com.example.botnari_shop.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity(name = "clients")
public class Client extends BaseEntity{
	
	private String firstName;
	private String lastName;
	private String email;
	@OneToMany(mappedBy = "client", cascade = CascadeType.MERGE, orphanRemoval = true)
	private List<Item> items = new ArrayList<>();
	private String phone;
	
	public Client(String firstName, String lastName, String email,String phone) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phone = phone;
	}
	
	
}
