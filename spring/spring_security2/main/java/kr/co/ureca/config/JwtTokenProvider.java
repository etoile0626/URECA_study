package kr.co.ureca.config;

import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class JwtTokenProvider {		//토큰 제공자
	
	private final UserDetailsService userDetailsService;
	
	@Value("${springboot.jwt.secret}")
	private String secretKey ="secretKey";
	
	private final long tokenValidMillisecend =1000L * 50 * 60;
	
	public String createToken( String userUid, List<String> roles ) {

		Date now = new Date();

		String token = Jwts.builder()
							.subject(userUid)
							.claim("roles", roles)
							.issuedAt(now)
							.expiration( new Date(now.getTime() + tokenValidMillisecend) )
							.signWith( Keys.hmacShaKeyFor( secretKey.getBytes( StandardCharsets.UTF_8 ) ) )
							.compact();
		System.out.println("JwtTokenProvider - createToken - token : " + token);

		return token;
	} // createToken
	
	public String getUsername(String token) {
		String info = Jwts.parser()
				.verifyWith(Keys.hmacShaKeyFor(secretKey.getBytes(StandardCharsets.UTF_8)))
				.build()
				.parseSignedClaims(token)
				.getPayload()
				.getSubject();
		
		System.out.println("JwtTokenProvider - getUsername - info : " + info);
		
		return info;
	}
	
	public Authentication getAuthentication(String token) {
		
		UserDetails userDetails 
			= userDetailsService.loadUserByUsername(this.getUsername(token));
		System.out.println("JwtTokenProvider - getAuthentication - getUsername : " + userDetails.getUsername() );
		
		return new UsernamePasswordAuthenticationToken(userDetails, "", userDetails.getAuthorities());
	}
	
	public String resolveToken(HttpServletRequest request) {
											//이 헤드값은 클라이언트 프로그래밍하는 사람이 입력?
		String tmpStr = request.getHeader("X-AUTH-TOKEN");	//특정 헤드 값이 가지고 있는 벨류 끄집어 내기?
		
		System.out.println("JwtTokenProvider - resolveToken - X-AUTH-TOKEN : " + tmpStr );
		
		return tmpStr;
	}
	
	public boolean validateToken(String token) {		//유효한 토큰인지 확인
		
		boolean tmpBool = false;
		
		try {
			Jws<Claims> claims 
							= Jwts.parser()
									.verifyWith(Keys.hmacShaKeyFor(secretKey.getBytes(StandardCharsets.UTF_8)))
									.build()
									.parseSignedClaims(token);
			
			//토큰에 기재된 날짜가 현재 날짜보다 이전인지 확인
			tmpBool = ! claims.getPayload().getExpiration().before(new Date());		
		} catch(Exception e) {
			tmpBool = false;
		}
		
		System.out.println("JwtTokenProvider - validateToken - tmpBool : " + tmpBool );
		
		return tmpBool;
		
	}
	
}
