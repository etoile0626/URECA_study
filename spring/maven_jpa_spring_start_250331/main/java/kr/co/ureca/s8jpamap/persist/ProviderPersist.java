package kr.co.ureca.s8jpamap.persist;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import kr.co.ureca.entity.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Table(name="provider_persist")
public class ProviderPersist extends BaseEntity{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String name;

	//@OneToMany(mappedBy = "provider", cascade = CascadeType.PERSIST)	//test1 , 2
	@OneToMany(mappedBy = "provider", cascade = CascadeType.PERSIST, orphanRemoval = true) //test3
	@ToString.Exclude
	private List<ProductPersist> productList = new ArrayList<>();

}
