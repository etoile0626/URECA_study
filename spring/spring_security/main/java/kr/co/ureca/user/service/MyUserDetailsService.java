package kr.co.ureca.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import kr.co.ureca.entity.User;
import kr.co.ureca.user.repository.UserRepository;

@Service
public class MyUserDetailsService implements UserDetailsService{
	//security 시작하면서 주구장창 나왔던 그 그림을 그대로 구현한 코드
	
	@Autowired
	private UserRepository repository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = repository.findByUsername(username);
		
		System.out.println("========================MyUserDetailsService - loadUserByUsername");
		System.out.println("user : " + user);
		System.out.println("========================MyUserDetailsService - loadUserByUsername");
		
		if(user == null) {
			return null;
		}
		
		return new MyUserDetails(user);
	}

	
}
