package com.doj.spittr.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.doj.spittr.entities.Dusr;


@Service("customUserDetailsService")
public class CustomUserDetailsService implements UserDetailsService{

	@Autowired
	private DusrService userService;
	
	@Transactional(readOnly=true)
	public UserDetails loadUserByUsername(String email)
			throws UsernameNotFoundException {
		Dusr user = userService.getUsrDetailByEmail(email);
		System.out.println("User : "+user);
		if(user==null){
			System.out.println("User not found");
			throw new UsernameNotFoundException("Username not found");
		}
			//return new org.springframework.security.core.userdetails.User(user.getUsreml(), user.getUsrpwd(), 
				 //user.getActive().equals("Active"), true, true, true, getGrantedAuthorities(user));
				 return new org.springframework.security.core.userdetails.User(user.getUsreml(), user.getUsrpwd(), 
						 "Active".equals("Active"), true, true, true, getGrantedAuthorities(user));
	}

	
	private List<GrantedAuthority> getGrantedAuthorities(Dusr user){
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		
		/*for(UserProfile userProfile : user.getUserProfiles()){
			System.out.println("UserProfile : "+userProfile);
			authorities.add(new SimpleGrantedAuthority("ROLE_"+userProfile.getType()));
		}*/
		authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
		System.out.print("authorities :"+authorities);
		return authorities;
	}
	
}
