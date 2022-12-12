package com.example.botnari_shop.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import com.example.botnari_shop.enums.ClientStatus;

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
	@OneToMany(mappedBy = "client", cascade = CascadeType.MERGE)
	private List<Item> items = new ArrayList<>();
	private ClientStatus status;
	private String phone;
	
	public Client(String firstName, String lastName, String email, ClientStatus status,String phone) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.status = status;
		this.phone = phone;
	}
	
	
}
