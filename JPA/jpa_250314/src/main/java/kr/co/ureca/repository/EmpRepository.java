package kr.co.ureca.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import kr.co.ureca.entity.Emp;

@Repository
public interface EmpRepository extends CrudRepository<Emp, Long>{
	
	public List<Emp> findAll();
	
	public List<Emp> findAllOrderByDeptnoDesc(); //findAll에서는 Order By 안 통하는 듯, 다른데선 괜춘
	
	public List<Emp> findBySalGraterThan(Integer sal);	//어떤 급여보다 많이
	
	public List<Emp> findBySalGraterThanEqual(Integer sal);
	
	public List<Emp> findBySalLessThan(Integer sal);	//어떤 급여보다 적게
	
	public List<Emp> findBySalLessThanEqual(Integer sal);
	
	public Emp findByEname(String ename);
	//이렇게 하면 레포지토리 쪽은 끝, 서비스 쪽에서 호출하면 얘가 알아서 다 줌?? WA

	public Emp findByEnameAndSal(String ename, Integer sal);

	public Emp findByEnameAndJobAndSal(String ename, String job, Integer sal);
	
	public List<Emp> findByEnameOrJobOrSal(String ename, String job, Integer sal);
	
	public List<Emp> findByJobLike(String job); //이렇게 Like 연산도 가능->근데 와일드카드는 안 만들어주고 있음 -> 입력할때 넣어주기

	@Query("SELECT e.id, e.empno, e.ename, e.job, e.mgr, e.hiredate, e.sal, e.comm, e.deptno"
			+ " FROM Emp e WHERE e.job = ?1 ")			//여기에 쿼리를 작성해서 넘겨줄 수 있음, 엔티티 선언시 이름과 동일하게 맞춰야 인식함
	public List<Object[]> findByQueryJob(String job);	//얘는 개발자가 임의로 정의한 메소드임, JPA가 알아 만들어준게 아님
	//@query에서 List하면 하나의 row는 Object[]로 리턴된다.
	
	//이렇게 쓰면 Emp 타입으로 주더라
	@Query("SELECT e FROM Emp e WHERE e.job = :jobName ")			//여기에 쿼리를 작성해서 넘겨줄 수 있음, 엔티티 선언시 이름과 동일하게 맞춰야 인식함
	public List<Emp> findByQueryJobParam(@Param("jobName") String job);	//얘는 개발자가 임의로 정의한 메소드임, JPA가 알아 만들어준게 아님

	//alias를 사용해서 쿼리를 쓰니까 오브젝트 타입으로 안나오더라
	@Query("select e FROM Emp e WHERE e.ename= ?1")
	public Emp findByQueryEname(String ename);
	
	@Query("select e FROM Emp e WHERE e.ename= :name") //param을 통해 ?1 대신 alias를 붙일 수 있음
	public Emp findByQueryEnameParam(@Param("name") String ename);


}
