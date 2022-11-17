package com.dipta.secure.services;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.dipta.secure.UserPrincipal;
import com.dipta.secure.UserRepo;
import com.dipta.secure.model.User;
@Service
public class UserDetailService implements UserDetailsService{
	@Autowired
	private UserRepo repo;
	@Override
	public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
		User user  = repo.findUserByName(name);
		if (user==null) {
			throw new UsernameNotFoundException("user 404 ;(");
		}
		return new UserPrincipal(user);
	}

}
