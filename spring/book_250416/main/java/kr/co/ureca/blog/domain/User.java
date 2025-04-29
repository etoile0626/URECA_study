package kr.co.ureca.blog.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Table(name = "users")
@NoArgsConstructor
@Getter
@Entity
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false)
    private Long id;

    @Column(name = "email", updatable = false, unique = true)
    private String email;

    @Column(name = "password")
    private String password;
    
    // 사용자 이름
    @Column(name = "nickname", unique = true)
    private String nickname;

    @Builder
    public User(String email, String password, String nickname){
        this.email = email;
        this.password = password;
        this.nickname = nickname;
    }

    @Override               //사용자의 권한 목록 반환
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("user"));
    }

    @Override       //사용자 이름 반환 (고유한 이름)
    public String getUsername() {
        return email;
    }

    @Override       //사용자 비밀번호 반환
    public String getPassword() {
        return password;
    }

    @Override       //계정이 만료 되었는지 확인
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override       //계정이 잠겼는지 확인
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override       //비밀번호 만료 확인
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override       //계정 사용여부 확인
    public boolean isEnabled() {
        return true;
    }
    
    //사용자 이름 변경
    public User update(String nickname){
        this.nickname = nickname;

        return this;
    }
}
