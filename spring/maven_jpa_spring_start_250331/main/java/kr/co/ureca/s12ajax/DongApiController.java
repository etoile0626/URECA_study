package kr.co.ureca.s12ajax;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kr.co.ureca.dto.DongDTO;

@RestController
@RequestMapping("/dong-api")
public class DongApiController {

	@Autowired
	private DongService dongService;

	@GetMapping("/sido")
	public List<DongDTO> sido() {
		return dongService.sido();
	} // sido

	@GetMapping("/gugun")
	public List<DongDTO> gugun(@RequestParam String code) {
		return dongService.gugun(code);
	} // gugun

	@GetMapping("/dong")
	public List<DongDTO> dong(@RequestParam String code) {
		return dongService.dong(code);
	} // dong

	@GetMapping("/search")
	public List<DongDTO> search(@RequestParam String name) {
		return dongService.search(name);
	} // search

} // class
