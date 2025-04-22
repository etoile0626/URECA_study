package kr.co.ureca.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import kr.co.ureca.entity.User;

public interface UserRepository extends JpaRepository<User, Long>{

	public User getByUid(String Uid);
}
