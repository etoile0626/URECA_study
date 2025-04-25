package kr.co.ureca.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Table(name = "code_gugun")
@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Gugun {

	@Id
	@Column(name = "gugun_code", nullable = false, unique = true)
	private String gugunCode;

	@Column(name = "gugun_name")
	private String gugunName;

} // class
