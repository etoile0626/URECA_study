package kr.co.ureca.dto.util;

import kr.co.ureca.dto.DongDTO;
import kr.co.ureca.entity.Dong;
import kr.co.ureca.entity.Gugun;
import kr.co.ureca.entity.Sido;

public class DongToDtO {

	public static DongDTO sidoToDTO( Sido sido ) {
		DongDTO dto = new DongDTO();
		dto.setCode( sido.getSidoCode() );
		dto.setName( sido.getSidoName() );
		return dto;
	} // sidoToDTO

	public static DongDTO gugunToDTO( Gugun gugun ) {
		DongDTO dto = new DongDTO();
		dto.setCode( gugun.getGugunCode() );
		dto.setName( gugun.getGugunName() );
		return dto;
	} // gugunToDTO

	public static DongDTO dongToDTO( Dong dong ) {
		DongDTO dto = new DongDTO();
		dto.setCode( dong.getDongCode() );
		dto.setName( dong.getDongName() );
		return dto;
	} // dongToDTO

} // class
