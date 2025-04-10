package kr.co.ureca.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import kr.co.ureca.dto.UserDTO;
import kr.co.ureca.entity.User;
import kr.co.ureca.user.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repository;
	
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	public UserDTO join(UserDTO dto) {
		
		User user = new User();
		user.setUsername(dto.getUsername());
		user.setPassword(encoder.encode( dto.getPassword() ) );
		User savedUser = repository.save(user);
		
		dto.setId(savedUser.getId());
		return dto;
	}
	
	/* spring security로 대체됨
	public UserDTO login(UserDTO dto) {
		User selectedUser = repository.findByUsernameAndPassword(dto.getUsername(), dto.getPassword());
		
		dto.setId(selectedUser.getId());
		return dto;
	}
	 	*/
}
