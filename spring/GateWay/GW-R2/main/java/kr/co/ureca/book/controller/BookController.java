package kr.co.ureca.book.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {

	@GetMapping("/reply")
	@ResponseBody
	public String replyTest() {
		return new String("<h1>GateWay-Reply2 Server-replyTest</h1>");
	}
}
