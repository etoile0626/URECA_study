package kr.co.ureca.s2ioc.service;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//@Service
public class PencilService implements PenService {

	public static final Logger logger = LoggerFactory.getLogger(PencilService.class);

	@Override
	public Map<String, String> write() {

		Map<String, String> map = new HashMap<>();
		map.put("Identity", "PencilService");
		map.put("isPencil", "true");
		map.put("isBallPen", "false");

		return map;
	} // write

} // class
