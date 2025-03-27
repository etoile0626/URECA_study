package kr.co.ureca.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class BoardDTO {

	private String bno;
	private String btitle;
	private String bwriter;
	private String bcnts;
	private String bdate;
	
}
