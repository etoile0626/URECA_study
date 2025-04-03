package kr.co.ureca.s5getpost.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import kr.co.ureca.entity.Emp;

@Repository
public interface EmpRepository extends JpaRepository<Emp, Long> {
	
	@Override
	default Optional<Emp> findById(Long id) {
		return Optional.empty();
	}

	public Emp findByEmpno(Integer empno);
	
	public List<Emp> findByDeptno(Integer deptno);
	
	public boolean existsByEmpno(Integer empno);
	
	public int countByDeptno(Integer deptno);
	
	public int deleteByEmpno(Integer deptno );
	
	public List<Emp> findTop3ByDeptno(Integer deptno);
	
	public List<Emp> findBySalLessThan(Integer sal);
	
	public List<Emp> findBySalGreaterThanEqual(Integer sal);
	
	public List<Emp> findBySalBetween(Integer losal, Integer hisal);
	
	public List<Emp> findByEnameLike(String ename);
	
	public List<Emp> findByEnameLikeOrderByDeptnoDesc(String ename);
	
	public List<Emp> findByEnameLikeOrderByDeptnoDescJobAsc(String ename);
	
	public List<Emp> findByEnameLike(String ename, Sort sort); 	//이렇게도 가능
	
	public Page<Emp> findBySalLessThanOrderByIdAsc(Integer sal, Pageable pageable);
	
	public List<Emp> findByDeptnoAndJob(Integer deptno, String job);

	public List<Emp> findByDeptnoOrJob(Integer deptno, String job);
	
	@Query("select e from emp e where e.ename = ?1")
	public Emp findByEnameQuery(String ename);
	
	@Query("select e from emp e where e.ename = :inName")
	public Emp findByEnameQueryParam(@Param("inName") String ename);
	
	@Query("select e.empno, e.ename, e.job, e.salm e.deptno from emp e where e.ename = :inName")
	//이렇게 일부분만 가져가게 되는 경우에는 Object타입으로 반환하게 됨
	public List<Object[]> findByEnameQueryParamObj(@Param("inName") String ename);

}


