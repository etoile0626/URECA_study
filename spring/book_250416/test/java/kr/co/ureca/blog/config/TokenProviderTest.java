package kr.co.ureca.blog.config;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import kr.co.ureca.blog.domain.User;
import kr.co.ureca.blog.repository.UserRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;

import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.Date;
import java.util.Map;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
public class TokenProviderTest {
    @Autowired
    private TokenProvider tokenProvider;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JwtProperties jwtProperties;

    @DisplayName("generateToken(): 유저 정보와 만료 기간을 전달해 토큰을 만들 수 있다.")
    @Test
    void generateToken(){
        User testUser  = userRepository.save(   User.builder().email("user@gmail.com")
                .password("test").build() );

        String token = tokenProvider.generateToken( testUser, Duration.ofDays(14) );
        System.out.println("token : " + token);

        Long userId = Jwts.parser()
                .verifyWith( Keys.hmacShaKeyFor(
                        jwtProperties.getSecretKey().getBytes( StandardCharsets.UTF_8 ) ) )
                .build()
                .parseSignedClaims(token)
                .getBody().get("id", Long.class);

        assertThat(userId).isEqualTo(testUser.getId());
    }

    @DisplayName("validToken(): 만료된 토큰인 경우에 유효성 검증에 실패한다.")
    @Test
    public void validToken_invalidToken() {
        String token = JwtFactory.builder()
                .expiration( new Date( new Date().getTime() - Duration.ofDays(7).toMillis() ) )
                .build()
                .createToken(jwtProperties);

        boolean result = tokenProvider.validToken(token);

        assertThat(result).isFalse();
    } // validToken_invalidToken

    @DisplayName("validToken() : 유효한 토큰인 경우에 유효성 검증에 성공한다.")
    @Test
    public void validToken_validToken() {
        String token = JwtFactory.withDefaultValues()
                .createToken(jwtProperties);

        boolean result = tokenProvider.validToken(token);

        assertThat(result).isTrue();
    } // validToken_validToken

    @DisplayName("getAuthentication() : 토큰기반으로 인증정보를 가져올 수 있다.")
    @Test
    public void getAuthentication() {
        String userEmail = "user@gmail.com";
        String token = JwtFactory.builder()
                .subject(userEmail)
                .build()
                .createToken(jwtProperties);        //토큰 생성

        //authentication 객체(인증 정보)를 token을 통해 받아옴
        Authentication authentication = tokenProvider.getAuthentication(token);

        assertThat( ( (UserDetails) authentication.getPrincipal() ).getUsername() )
                .isEqualTo(userEmail);
    } // getAuthentication

    @DisplayName("getUserId() : 토큰으로 유저 ID를 가져올 수 있다.")
    @Test
    public void getUserId() {
        Long userId = 1L;
        String token = JwtFactory.builder()
                .claims(Map.of("id", userId))
                .build()
                .createToken(jwtProperties);

        Long userIdByToken = tokenProvider.getUserId(token);

        assertThat(userIdByToken).isEqualTo(userId);
    } // getUserId
}
