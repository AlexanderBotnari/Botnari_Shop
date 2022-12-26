package com.example.botnari_shop.entities;

import javax.persistence.Entity;

import com.example.botnari_shop.enums.Role;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "users")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class User extends BaseEntity{

	private String userFirstName;
	private String userLastName;
	private String userEmail;
	private String userPhone;
	private String password;
	private Role userRole;
}
