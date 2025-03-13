package kr.co.ureca.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.co.ureca.dto.EmpDTO;

@Mapper
public interface MybatisInterface2 {

	public List<EmpDTO> getAllEmp2();
}

/*
 * interface와 xml을 결합한 방식
 * mapper의 namespace는 interface이름
 * mapper의 id는 인터페이스 메소드 이름
<mapper namespace = "kr.co.ureca.mapper.MybatisInterface2"> <!-- 이 방법에선 이 이름이 제일 중요함 -->
<!-- 쿼리문 중 ?에 값을 채워주는게 파라미터타입, 결과를 받아오는게 result 타입, 링크형태여야함(컨트롤클릭이 눌러져야 제대로 쓴거) -->
	
	<select id="getAllEmp2" resultType="kr.co.ureca.dto.EmpDTO"> 
		SELECT empno, ename, job, mgr, hiredate, sal, comm, deptno 
		FROM emp 
		ORDER BY ename 
	</select>
</mapper>
*/
