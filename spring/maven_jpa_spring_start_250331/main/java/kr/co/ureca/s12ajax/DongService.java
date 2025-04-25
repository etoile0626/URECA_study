package kr.co.ureca.s12ajax;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.ureca.dto.DongDTO;
import kr.co.ureca.dto.util.DongToDtO;
import kr.co.ureca.entity.Dong;
import kr.co.ureca.entity.Gugun;
import kr.co.ureca.entity.Sido;

@Service
public class DongService {

	@Autowired
	private SidoRepository sidoRepository;

	@Autowired
	private GugunRepository gugunRepository;

	@Autowired
	private DongRepository dongRepository;

	public List<DongDTO> sido() {
		List<Sido> sidoList = sidoRepository.findAll();

		List<DongDTO> list = new ArrayList<>();

		for (Sido sido : sidoList) {
			list.add( DongToDtO.sidoToDTO(sido) );
		} // for

		return list;
	} // sido

	public List<DongDTO> gugun(String code) {
		String serachKey = code.substring(0, 2) + "%";

		List<Gugun> gugunList = gugunRepository.findByGugunCodeLike(serachKey);

		List<DongDTO> list = new ArrayList<>();

		for (Gugun gugun : gugunList) {
			list.add( DongToDtO.gugunToDTO(gugun) );
		} // for

		return list;
	} // sido

	public List<DongDTO> dong(String code) {
		String serachKey = code.substring(0, 5) + "%";

		List<Dong> dongList = dongRepository.findByDongCodeLike(serachKey);

		List<DongDTO> list = new ArrayList<>();

		for (Dong dong : dongList) {
			list.add( DongToDtO.dongToDTO(dong) );
		} // for

		return list;
	} // dong

	public List<DongDTO> search(String name) {
		String serachKey = name + "%";

		List<Dong> dongList = dongRepository.findByDongNameLike(serachKey);

		List<DongDTO> list = new ArrayList<>();

		for (Dong dong : dongList) {
			list.add( DongToDtO.dongToDTO(dong) );
		} // for

		return list;
	} // dong

} // class







