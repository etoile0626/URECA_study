package kr.co.ureca.service;

import java.util.HashMap;

import org.apache.hc.core5.net.URIBuilder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import kr.co.ureca.dto.MemberDTO;

//서버1
@Service
public class WebClientService {
	
	public String s1Test1() {
		
		WebClient webClient 
			= WebClient.builder()
				.baseUrl("http://localhost:8090")
				.defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
				.build();				//정석적인 webClient 만들기
		
		return webClient.get().uri("/s2/api/test1")
				.retrieve()					//조회하겠다
				.bodyToMono(String.class)	//리스트가 아니라 객체 하나 가져오겠다
				.block();	
	}
	
	public String s1Test2(String id, String pwd) {
		
		WebClient webClient 
			= WebClient.create("http://localhost:8090");	//간결하게 만드는 webclient
		
		ResponseEntity<String> responseEntity
				= webClient.get()
				.uri(uriBuilder -> uriBuilder.path("/s2/api/test2/{id}/{pwd}").build(id, pwd))
				.retrieve().toEntity(String.class).block();
		
		return responseEntity.getBody();
	}
	
	public String s1Test3(String id, String pwd) {

		WebClient webClient = WebClient.create("http://localhost:8090");

		return webClient
				.get()
				.uri(uriBuilder -> uriBuilder.path("/s2/api/test3")
												.queryParam("id", id)
												.queryParam("pwd", pwd)
												.build(id, pwd))
				.exchangeToMono(clientResponse -> {
					if( clientResponse.statusCode().equals(HttpStatus.OK) ) {
						return clientResponse.bodyToMono(String.class);
					} else {
						return clientResponse.createError();
					}
				})
				.block();
	} // s1Test3
	
	public ResponseEntity<MemberDTO> s1Test4(MemberDTO dto) {
		WebClient webClient 
		= WebClient.builder()
			.baseUrl("http://localhost:8090")
			.defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
			.build();
		
		return webClient
				.post()													
				.uri(uriBuilder -> uriBuilder.path("/s2/api/test4").build(new HashMap<String, String>()))
				.bodyValue(dto)
				.retrieve()
				.toEntity(MemberDTO.class)
				.block();
	}
	
	public ResponseEntity<MemberDTO> s1Test5( MemberDTO dto ) {
		WebClient webClient
			= WebClient.builder()
						.baseUrl("http://localhost:8090")
						.defaultHeader(HttpHeaders.CONTENT_TYPE
										, MediaType.APPLICATION_JSON_VALUE)
						.build();

		return webClient
				.post()
				.uri(uriBuilder -> uriBuilder.path("/s2/api/test5").build(new HashMap<String,String>()))
				.bodyValue(dto)
				.header("my-header", "test-api from WebClientService")
				.retrieve()
				.toEntity(MemberDTO.class)
				.block();
	} // s1Test5
}
