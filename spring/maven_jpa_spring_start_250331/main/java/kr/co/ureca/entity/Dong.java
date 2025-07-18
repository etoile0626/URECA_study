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

@Table(name = "code_dong")
@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Dong {

	@Id
	@Column(name = "dong_code", nullable = false, unique = true)
	private String dongCode;

	@Column(name = "dong_name")
	private String dongName;

} // class
