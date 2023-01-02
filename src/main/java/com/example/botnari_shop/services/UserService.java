package com.example.botnari_shop.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.example.botnari_shop.entities.User;
import com.example.botnari_shop.entities.UserItem;
import com.example.botnari_shop.repositories.UserRepository;

@Service
public class UserService implements UserDetailsService{

	@Autowired
	UserRepository userRepo;
	
	public List<User> getUsers(){
		return userRepo.findAll();
	}
	
	public Optional<User> getUserById(Integer user) {
		return userRepo.findById(user);
	}
	
	public void saveUser(User user) {
		userRepo.save(user);
	}
	
	public void deleteUser(User user) {
		userRepo.delete(user);
	}
	
	public User getUserByPhone(String phone) {
		return userRepo.findByPhone(phone).get();
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepo.findByUserName(username).get();
		
		if (user == null) {
            throw new UsernameNotFoundException(username);
        }
		
        return new UserItem(user);
	}
}
