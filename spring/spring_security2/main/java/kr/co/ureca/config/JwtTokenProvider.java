package kr.co.ureca.config;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import jakarta.annotation.PostConstruct;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class JwtTokenProvider {		//토큰 제공자

	private final Logger logger = LoggerFactory.getLogger(JwtTokenProvider.class);
	
	private final UserDetailsService userDetailsService;
	
	
	private String secretkey ="secretkey";
	
	private final long tokenValidMillisocend =1000L * 50 * 60;
	
	@PostConstruct		//construct가 수행된 후 수행해라
	private void init() {
		secretkey = Base64.getEncoder()
				.encodeToString(secretkey.getBytes(StandardCharsets.UTF_8));
		
		logger.info("init security cu :" + secretkey);
	}
	
	public String createToken(String userUid, List<String> roles) {
		Claims claims = (Claims) Jwts.claims().subject(userUid);
		claims.put("roles", roles);
		
		Date now = new Date();
		
		String token = Jwts.builder().claims(claims)
									.issuedAt(now)
									.expiration(new Date(now.getTime() + tokenValidMillisocend))
									.signWith(Keys.hmacShaKeyFor(secretkey.getBytes(StandardCharsets.UTF_8)))
									.compact();
		
		logger.info("createToken - token : " + token);
		
		return token;
	}
	
	public String getUsername(String token) {
		String info = Jwts.parser()
				.verifyWith(Keys.hmacShaKeyFor(secretkey.getBytes(StandardCharsets.UTF_8)))
				.build()
				.parseSignedClaims(token)
				.getPayload()
				.getSubject();
		
		logger.info("getUsername - token : " + info);
		
		return info;
	}
	
	public Authentication getAuthentication(String token) {
		
		UserDetails userDetails 
			= userDetailsService.loadUserByUsername(this.getUsername(token));
		logger.info("getAuthentication - UserDetails : " + userDetails.getUsername());
		
		return new UsernamePasswordAuthenticationToken(userDetails, "", userDetails.getAuthorities());
	}
	
	public String resolveToken(HttpServletRequest request) {
		
		String tmpStr = request.getHeader("X-AUTH-TOKEN");	//특정 헤드 값이 가지고 있는 벨류 끄집어 내기?
		
		logger.info("resolveToken - X-AUTH-TOKEN : " + tmpStr);
		
		return tmpStr;
	}
	
	public boolean validateToken(String token) {
		
		boolean tmpBool = false;
		
		try {
			Jws<Claims> claims 
							= Jwts.parser()
									.verifyWith(Keys.hmacShaKeyFor(secretkey.getBytes(StandardCharsets.UTF_8)))
									.build()
									.parseSignedClaims(token);
			
			tmpBool = ! claims.getPayload().getExpiration().before(new Date());
		} catch(Exception e) {
			tmpBool = false;
		}
		
		logger.info("resolveToken - X-AUTH-TOKEN : " + tmpBool);
		
		return tmpBool;
		
	}
	
}
