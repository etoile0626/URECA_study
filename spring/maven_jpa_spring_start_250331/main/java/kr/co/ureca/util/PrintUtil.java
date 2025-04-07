package kr.co.ureca.util;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.co.ureca.dto.EmpDTO;
import kr.co.ureca.dto.EmpDTO2;
import kr.co.ureca.entity.Emp;

public class PrintUtil {

	public static Logger logger = null;

	public static void printEmpList(Class<?> clazz, String methodName, List<Emp> empList) {
		logger = LoggerFactory.getLogger(clazz);
		logger.info(methodName + " start ===========================================");
		for (Emp emp : empList) {
			logger.info(emp.toString());
		} // for
		logger.info(methodName + " end =============================================");
	}

	public static void printEmpDTOList(Class<?> clazz, String methodName, List<EmpDTO> empDTOList) {
		logger = LoggerFactory.getLogger(clazz);
		logger.info(methodName + " start ===========================================");
		for (EmpDTO empDTO : empDTOList) {
			logger.info(empDTO.toString());
		} // for
		logger.info(methodName + " end =============================================");
	}

	public static void printEmpDTO2List(Class<?> clazz, String methodName, List<EmpDTO2> empDTO2List) {
		logger = LoggerFactory.getLogger(clazz);
		logger.info(methodName + " start ===========================================");
		for (EmpDTO2 empDTO : empDTO2List) {
			logger.info(empDTO.toString());
		} // for
		logger.info(methodName + " end =============================================");
	}

} // class
