package com.test.java.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.test.java.mapper.MemberMapper;
import com.test.java.model.CustomUser;
import com.test.java.model.MemberDTO;

//스프링 시큐리티 > 회원 > username, password, enabled, authority + A
public class CustomUserDetailsService implements UserDetailsService {
	
	@Autowired
	private MemberMapper mapper;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		MemberDTO dto = mapper.get(username);
		
		return dto != null ? new CustomUser(dto) : null;
	}
	
}









