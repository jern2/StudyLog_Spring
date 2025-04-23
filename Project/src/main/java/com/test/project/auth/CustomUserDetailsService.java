package com.test.project.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.test.project.mapper.MemberMapper;
import com.test.project.model.CustomUser;
import com.test.project.model.MemberDTO;

public class CustomUserDetailsService implements UserDetailsService {
	
	@Autowired
	private MemberMapper mapper;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		MemberDTO dto = mapper.get(username);
		
		return dto != null ? new CustomUser(dto) : null;
	}
	
}



