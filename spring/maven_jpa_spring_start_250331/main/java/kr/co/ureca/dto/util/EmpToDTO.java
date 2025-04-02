package kr.co.ureca.dto.util;

import kr.co.ureca.dto.EmpDTO;
import kr.co.ureca.entity.Emp;

public class EmpToDTO {

	public static EmpDTO empToDTO(Emp emp) {
		EmpDTO dto = new EmpDTO();
		dto.setId(emp.getId());
		dto.setEmpno(emp.getEmpno());
		dto.setEname(emp.getEname());
		dto.setJob(emp.getJob());
		dto.setMgr(emp.getMgr());
		dto.setHiredate(emp.getHiredate());
		dto.setSal(emp.getSal());
		dto.setComm(emp.getComm());
		dto.setDeptno(emp.getDeptno());
		
		return dto;
	}
	
	public static Emp dtoToEmp(EmpDTO dto) {
		Emp emp = new Emp();
		emp.setEmpno(dto.getEmpno());
		emp.setEname(dto.getEname());
		emp.setJob(dto.getJob());
		emp.setMgr(dto.getMgr());
		emp.setHiredate(dto.getHiredate());
		emp.setSal(dto.getSal());
		emp.setComm(dto.getComm());
		emp.setDeptno(dto.getDeptno());
		return emp;
	}
}
