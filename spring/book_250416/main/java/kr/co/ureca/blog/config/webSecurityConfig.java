package kr.co.ureca.blog.config;

import kr.co.ureca.blog.service.UserDetailService;
import lombok.RequiredArgsConstructor;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class webSecurityConfig {
    
    private final UserDetailService userService;
    
    @Bean   //이런 예외 적용도 다 빈으로 등록해야함
    public WebSecurityCustomizer configure() {
        return (web)
                -> web.ignoring()
                //.requestMatchers(toH2Console())<-우린 h2 안쓰고 있어서 //static 밑에 있는것들 다
                .requestMatchers(new AntPathRequestMatcher("/static/**"));       
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return http.authorizeRequests( auth
                        -> auth.requestMatchers(
                                new AntPathRequestMatcher("/login"),
                                new AntPathRequestMatcher("/signup"),
                                new AntPathRequestMatcher("/user")
                        ).permitAll()
                        .anyRequest().authenticated() ) // authorizeRequests
                .formLogin( formLogin
                        -> formLogin.loginPage("/login")
                        .defaultSuccessUrl("/articles") ) // formLogin
                .logout( logout
                        -> logout.logoutSuccessUrl("/login")
                        .invalidateHttpSession(true) ) // logout
                .csrf(AbstractHttpConfigurer::disable)
                .build();
    } // filterChain

    @Bean
    public AuthenticationManager authenticationManager(HttpSecurity http
                                            , BCryptPasswordEncoder bCryptPasswordEncoder
                                            , UserDetailService userDetailService)throws Exception{

        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userService);
        authProvider.setPasswordEncoder(bCryptPasswordEncoder);

        return new ProviderManager(authProvider);
    }

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
