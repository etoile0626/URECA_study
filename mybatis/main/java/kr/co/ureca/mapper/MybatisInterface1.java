package kr.co.ureca.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import kr.co.ureca.dto.EmpDTO;

@Mapper 	//인터페이스로 mapper를 만드는 어노테이션
public interface MybatisInterface1 {
	@Select("SELECT empno, ename, job, mgr, hiredate, sal, comm, deptno"
			+ " FROM emp"
			+ " order by ename")
	public List<EmpDTO> getAllEmp1();
	
	@Select("SELECT empno, ename, job, mgr, hiredate, sal, comm, deptno" 
			+" FROM emp WHERE ename = #{ename}")
	public EmpDTO getEmpByEname1( @Param("enameParam") String ename);
	// @Param이 여러개 필요할 경우 : ( @Param("enameParam") String ename, @Param("salParam") String sal, ...)

	@Insert("INSERT INTO emp (ename, job, mgr, hiredate, sal, comm, deptno)"
			+ " VALUES ( #{ename}, #{job}, #{mgr}"
			+ ", now(), #{sal}, #{comm}, #{deptno} )")
	public int insEmp1(@Param("param") EmpDTO dto);
}
