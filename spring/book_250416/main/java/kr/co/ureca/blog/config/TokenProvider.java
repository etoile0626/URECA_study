package kr.co.ureca.blog.config;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Header;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import kr.co.ureca.blog.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.Collections;
import java.util.Date;
import java.util.Set;

@RequiredArgsConstructor
@Service
public class TokenProvider {
    private final JwtProperties jwtProperties;
    
    public String generateToken(User user, Duration expired){

        Date now = new Date();

        return makeToken(new Date( now.getTime() + expired.toMillis()), user);
    }

    private String makeToken(Date expiry, User user){
        Date now = new Date();
        //모르겠다 왜이러는데 뭐 고쳐야함?
        return Jwts.builder()
                .setHeaderParam(Header.TYPE, Header.JWT_TYPE)
                .issuer(jwtProperties.getIssuer())
                .expiration(expiry)
                .subject(user.getEmail())
                .claim("id", user.getId())
                //.signWith(SignatureAlogithm.HS256, jwtProperties.getSecretKey())
                .signWith(Keys.hmacShaKeyFor(jwtProperties.getSecretKey().getBytes(StandardCharsets.UTF_8)))
                .compact();
    }

    public boolean validToken(String token){
        try{
            /* 구시대의 산물
            Jwts.parser()
                    .setSigningKey(jwtProperties.getSecretKey())
                    .build()
                    .parseClaimsJws(token);
            */
            Jwts.parser()
                    .verifyWith( Keys.hmacShaKeyFor( jwtProperties.getSecretKey().getBytes( StandardCharsets.UTF_8 ) ) )
//                    .setSigningKey(jwtProperties.getSecretKey())
                    .build()
                    .parseSignedClaims(token);
            return true;
        } catch (Exception e){
            return false;
        }
    }

    private Claims getClaims(String token){
        return Jwts.parser()
                .verifyWith( Keys.hmacShaKeyFor( jwtProperties.getSecretKey().getBytes( StandardCharsets.UTF_8 ) ) )
//                .setSigningKey(jwtProperties.getSecretKey())
                .build()
                .parseClaimsJws(token) //parseSignedClaims로 바꿔야하나
                .getBody();
    }

    public Long getUserId(String token){
        Claims claims = getClaims(token);
        return claims.get("id", Long.class);
    }

    public Authentication getAuthentication(String token){
        Claims claims = getClaims(token);
        Set<SimpleGrantedAuthority> authorities
                = Collections.singleton(new SimpleGrantedAuthority("ROLE_USER"));

        return new UsernamePasswordAuthenticationToken(
                new org.springframework.security.core.userdetails.User(
                        claims.getSubject(), "", authorities)
                , token
                , authorities);
    }
}
