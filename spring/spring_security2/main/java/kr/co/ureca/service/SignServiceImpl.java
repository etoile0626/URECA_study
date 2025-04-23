package kr.co.ureca.service;

import java.util.Collections;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import kr.co.ureca.config.JwtAuthenticationFilter;
import kr.co.ureca.config.JwtTokenProvider;
import kr.co.ureca.dto.CommonResponse;
import kr.co.ureca.dto.SignInResultDto;
import kr.co.ureca.dto.SignUpResultDto;
import kr.co.ureca.entity.User;
import kr.co.ureca.repository.UserRepository;

@Service
public class SignServiceImpl implements SignService{
	
	private final Logger logger = LoggerFactory.getLogger(SignServiceImpl.class);
	
	private UserRepository userRepository; 
	
	private JwtTokenProvider jwtTokenProvider;
	
	private PasswordEncoder passwordEncoder;
	
	public SignServiceImpl(UserRepository userRepository, JwtTokenProvider jwtTokenProvider
			, PasswordEncoder passwordEncoder){
		this.userRepository = userRepository;
		this.jwtTokenProvider = jwtTokenProvider;
		this.passwordEncoder = passwordEncoder;
	}

	@Override
	public SignUpResultDto signUp(String id, String password, String name, String role) {
		User user;
		
		if(role.equalsIgnoreCase("admin")) {		//회원가입하는애가 어드민이면
			user = User.builder().uid(id)
									.name(name)
									.password(passwordEncoder.encode(password))
									.roles(Collections.singletonList("ROLE_ADMIN"))	//역할 어드민으로
									.build();
		} else {
			user = User.builder().uid(id)
					.name(name)
					.password(passwordEncoder.encode(password))
					.roles(Collections.singletonList("ROLE_USER"))	//역할 유저으로
					.build();
		}
		
		User savedUser = userRepository.save(user);
		SignUpResultDto signUpResultDto = new SignUpResultDto();
		
		if(!savedUser.getName().isEmpty()) {
			setSuccessResult(signUpResultDto);
		} else {
			setFailResult(signUpResultDto);
		}
		
		logger.info("signUp - dto : " + signUpResultDto);
		
		return signUpResultDto;
	}

	@Override
	public SignInResultDto signIn(String id, String password) {
		
		User user = userRepository.getByUid(id);
		if(!passwordEncoder.matches(password, user.getPassword())) {
			throw new RuntimeException();
		}
		
		SignInResultDto signInResultDto
							= SignInResultDto.builder()
						.token(jwtTokenProvider.createToken(
									String.valueOf(user.getUid()), user.getRoles()))
						.build();
		setSuccessResult(signInResultDto);

		return signInResultDto;
	}
	
	private void setSuccessResult(SignUpResultDto result) {
		result.setSuccess(true);
		result.setCode(CommonResponse.SUCCESS.getCode());
		result.setMsg(CommonResponse.SUCCESS.getMsg());
	}
	
	private void setFailResult(SignUpResultDto result) {
		result.setSuccess(false);
		result.setCode(CommonResponse.FAIL.getCode());
		result.setMsg(CommonResponse.FAIL.getMsg());
	}

}
