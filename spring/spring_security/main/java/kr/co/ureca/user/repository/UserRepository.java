package kr.co.ureca.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kr.co.ureca.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
	
	//spring security로 대체됨
	//User findByUsernameAndPassword(String username, String password);

	User findByUsername(String username);

}
