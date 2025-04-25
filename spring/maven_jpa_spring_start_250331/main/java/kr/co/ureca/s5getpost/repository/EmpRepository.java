package kr.co.ureca.s5getpost.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import kr.co.ureca.entity.Emp;

@Repository
public interface EmpRepository extends JpaRepository<Emp, Long> {

	public Emp findByEmpno(Integer empno);

	public List<Emp> findByDeptno(Integer deptno);

	public boolean existsByEmpno( Integer empno );

	public int countByDeptno( Integer deptno );

	public int deleteByEmpno( Integer empno );

	public List<Emp> findTop3ByDeptno(Integer deptno);

	public List<Emp> findBySalLessThan(Integer sal);

	public List<Emp> findBySalGreaterThanEqual(Integer sal);

	public List<Emp> findBySalBetween(Integer loSal, Integer hiSal);

	public List<Emp> findByEnameLike(String ename);

	public List<Emp> findByEnameLikeOrderByDeptnoDesc(String ename);

	public List<Emp> findByEnameLikeOrderByDeptnoDescJobAsc(String ename);

	public List<Emp> findByEnameLike(String ename, Sort sort);

	public Page<Emp> findBySalLessThanOrderByIdAsc(Integer sal, Pageable pageable);

	public List<Emp> findByDeptnoAndJob(Integer deptno, String job);

	public List<Emp> findByDeptnoOrJob(Integer deptno, String job);

	@Query("SELECT e FROM Emp AS e WHERE e.ename = ?1")
	public Emp findByEnameQuery(String ename);

	@Query("SELECT e FROM Emp e WHERE e.ename = :inName")
	public Emp findByEnameQueryParam(@Param("inName") String ename);

	@Query("SELECT e.empno, e.ename, e.job, e.sal, e.deptno FROM Emp e WHERE e.ename = :inName")
	public List<Object[]> findByEnameQueryParamObj(@Param("inName") String ename);

} // interface
