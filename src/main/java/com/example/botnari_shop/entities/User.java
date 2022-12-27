package com.example.botnari_shop.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;


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
//	Test data to postgree(login:admin, pass:admin)
//	INSERT INTO public.base_entity(
//			dtype, id, type, user_name, user_role, password)
//			VALUES ('users',1, 'users', 'admin', 1, '$2a$10$U6S/4U7dOmCHvE49DEZ8BezwChvmle3EcPrNgOL66ST/cTTGdKhKi');
//	
	private String userName;
	private String userFirstName;
	private String userLastName;
	private String userEmail;
	private String phone;
	private String password;
	
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Role> roles = new HashSet<>();
	
	public User(String userName, String userFirstName, String userLastName, String userEmail,
			String phone, String password) {
		this.userName = userName;
		this.userFirstName = userFirstName;
		this.userLastName = userLastName;
		this.userEmail = userEmail;
		this.phone = phone;
		this.password = password;
	}


	
}
