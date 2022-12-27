package com.example.botnari_shop.entities;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;


public class UserItem implements UserDetails{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private User user;

	public UserItem(User user) {
		super();
		this.user = user;
	}
	
    public UserItem() {
		super();
	}

	@Override
    public Collection<GrantedAuthority> getAuthorities() {		
        return Collections.singleton(new SimpleGrantedAuthority("USER"));
    }

    @Override
    public String getPassword() {
            return user.getPassword();
    }
    
    @Override
    public String getUsername() {
            if (this.user == null) {
                    return null;
            }
            return this.user.getUserName();
    }

    @Override
    public boolean isAccountNonExpired() {
            return true;
    }

    @Override
    public boolean isAccountNonLocked() {
            return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
            return true;
    }

    @Override
    public boolean isEnabled() {
            return true;
    }

    public User getUser() {
            return user;
    }

    @Override
    public String toString() {
            return "CustomUserDetails [user=" + user + "]";
    }
}
