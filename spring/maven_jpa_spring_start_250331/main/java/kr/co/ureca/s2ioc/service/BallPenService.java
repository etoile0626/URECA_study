package kr.co.ureca.s2ioc.service;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class BallPenService implements PenService {

	public static final Logger logger = LoggerFactory.getLogger(BallPenService.class);

	@Override
	public Map<String, String> write() {

		Map<String, String> map = new HashMap<>();
		map.put("Identity", "BallPenService");
		map.put("isBallPen", "true");
		map.put("isPencil", "false");

		return map;
	} // write

} // class
