package kr.co.ureca.blog.config;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@RequiredArgsConstructor
public class TokenAuthenticationFilter extends OncePerRequestFilter {
    
    private final TokenProvider tokenProvider;
    private final static String HEADER_AUTHORIZATION = "authorization";
    private final static String TOKEN_PREFIX = "Bearer "; //맨 뒤에 공백 있는거 생각


    @Override
    protected void doFilterInternal(HttpServletRequest request
                            , HttpServletResponse response
                            , FilterChain filterChain) throws ServletException, IOException {
        String authorizationHeader = request.getHeader(HEADER_AUTHORIZATION);   //이게 사실상 토큰?
        String token = getAccessToken(authorizationHeader);     //접두사만 제거하면 진짜 토큰

        if(tokenProvider.validToken(token)){
            Authentication authentication = tokenProvider.getAuthentication(token);
            SecurityContextHolder.getContext().setAuthentication(authentication);
        }

        filterChain.doFilter(request, response);
    }

    private String getAccessToken(String authorizationHeader){
        //authorizationHeader가 Bearer 로 시작하면 잘라줘라
        if(authorizationHeader != null && authorizationHeader.startsWith(TOKEN_PREFIX)){
            return authorizationHeader.substring(TOKEN_PREFIX.length());
        }
        return null;
    }
}
