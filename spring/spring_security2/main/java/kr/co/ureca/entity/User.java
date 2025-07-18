package kr.co.ureca.entity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table
public class User implements UserDetails{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false, unique = true)
	private String uid;
	
	@Column(nullable = false)
	@JsonProperty(access = Access.WRITE_ONLY)
	private String password;
	
	@Column(nullable = false)
	private String name;
	
	@ElementCollection(fetch = FetchType.EAGER)		//즉시 조회
	@Builder.Default
	private List<String> roles = new ArrayList<>();

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return this.roles.stream().map(SimpleGrantedAuthority :: new).collect(Collectors.toList());
	}

	@Override
	@JsonProperty(access = Access.WRITE_ONLY)
	public String getUsername() {
		return this.uid;
	}
	
	@Override
	@JsonProperty(access = Access.WRITE_ONLY)
	public boolean isAccountNonExpired() {
		return true;
	}
	
	@Override
	@JsonProperty(access = Access.WRITE_ONLY)
	public boolean isAccountNonLocked() {
		return true;
	}
	
	@Override
	@JsonProperty(access = Access.WRITE_ONLY)
	public boolean isCredentialsNonExpired() {	//
		return true;
	}
	
	@Override
	public boolean isEnabled() {				//활성화 상태냐
		return true;
	}
	
}
