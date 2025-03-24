package kr.co.ureca.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.ureca.entity.Emp;
import kr.co.ureca.service.EmpService;

@RequestMapping("/emp")
@Controller
public class EmpApiReactController {

	@Autowired
	private EmpService empService;

	@GetMapping("/list")
	@CrossOrigin(origins = "*", methods = RequestMethod.GET)
	@ResponseBody
	public List<Emp> empListAll() {

		List<Emp> list = empService.empFindAll();

		return list;
	} // empListAll

	@GetMapping(value = "/detail/{id}")
	@CrossOrigin(origins = "*", methods = RequestMethod.GET)
	@ResponseBody
	public Emp empOne( @PathVariable("id") String id ) {

		Emp emp = empService.empFindById( id );

		return emp;
	} // empOne

	@PostMapping(value = "/insert")
	@CrossOrigin(origins = "*", methods = RequestMethod.POST)
	@ResponseBody
	public Long empInsert( @RequestBody Emp emp ) {

		Long primaryKey = empService.empInsert( emp );

		return primaryKey;
	} // empInsert

	@DeleteMapping(value = "/delete/{id}")
	@CrossOrigin(origins = "*", methods = RequestMethod.DELETE)
	@ResponseBody
	public Long empDelete( @PathVariable("id") String id ) {

		Long primaryKey = empService.empDelete( id );

		return primaryKey;
	} // empDelete

	@PostMapping(value = "/update")
	@CrossOrigin(origins = "*", methods = RequestMethod.POST)
	@ResponseBody
	public Long empUpdate( @RequestBody Emp emp ) {

		Long primaryKey = empService.empInsert( emp );

		return primaryKey;
	} // empInsert

} // class
