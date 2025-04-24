package kr.co.ureca.blog.service;

import kr.co.ureca.blog.config.TokenProvider;
import kr.co.ureca.blog.domain.User;
import kr.co.ureca.blog.repository.RefreshTokenRepository;
import kr.co.ureca.blog.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Duration;

@RequiredArgsConstructor
@Service
public class TokenService {
    private final TokenProvider tokenProvider;
    //서비스 호출하는건 좋은게 아님 차라리 레포지토리 불러올것
    //private final RefreshTokenService refreshTokenService;
    //private final UserService userService;
    private final RefreshTokenRepository refreshTokenRepository;
    private final UserRepository userRepository;

    public String createNewAccessToken(String refreshToken){
        if(!tokenProvider.validToken(refreshToken)){
            throw new IllegalArgumentException("Unexpected token");
        }

        Long userId = refreshTokenRepository.findByRefreshToken(refreshToken).get().getUserId();
        User user = userRepository.findById(userId).get();

        return tokenProvider.generateToken(user, Duration.ofHours(2));
    }
}
