package com.example.botnari_shop.entities;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.example.botnari_shop.entities.finance.Price;
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
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String firstName;
	private String lastName;
	private String email;
	@OneToOne(cascade = CascadeType.ALL)
	private Product product;
	@OneToOne(cascade = CascadeType.ALL)
	private Price price;
	private ClientStatus status;
	private String phone;
	
	public Client(String firstName, String lastName, String email, ClientStatus status, String phone) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.status = status;
		this.phone = phone;
	}
	
	
}
