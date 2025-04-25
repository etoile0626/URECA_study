package kr.co.ureca.s12ajax;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kr.co.ureca.entity.Gugun;

public interface GugunRepository extends JpaRepository<Gugun, String> {

	public List<Gugun> findByGugunCodeLike(String sidoCode);

} // interface
