package kr.co.ureca.s12ajax;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kr.co.ureca.entity.Dong;

public interface DongRepository extends JpaRepository<Dong, String> {

	public List<Dong> findByDongCodeLike(String gugunCode);

	public List<Dong> findByDongNameLike(String dongName);

} // interface
