package kr.co.ureca.service;

import java.net.URI;
import java.util.concurrent.TimeUnit;

import org.apache.hc.client5.http.config.ConnectionConfig;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.HttpClientBuilder;
import org.apache.hc.client5.http.impl.io.PoolingHttpClientConnectionManager;
import org.apache.hc.client5.http.impl.io.PoolingHttpClientConnectionManagerBuilder;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import kr.co.ureca.dto.MemberDTO;

//서버1
@Service
public class RestTemplateService {
	
	private RestTemplate getRestTemplate() {	//RestTemplate을 get 메소드를 통해서 가져오기
		//타임아웃 설정
		ConnectionConfig httpConfig = ConnectionConfig.custom()
												.setSocketTimeout(5000, TimeUnit.MILLISECONDS)
												.setConnectTimeout(5000L, TimeUnit.MILLISECONDS)
												.build();
		//커넥션 풀 관리자 설정
		PoolingHttpClientConnectionManager httpManager
					= PoolingHttpClientConnectionManagerBuilder
						.create().setDefaultConnectionConfig(httpConfig).build();
		
		//
		CloseableHttpClient httpClient
					= HttpClientBuilder.create().setConnectionManager(httpManager).build();

		//
		HttpComponentsClientHttpRequestFactory factory
					= new HttpComponentsClientHttpRequestFactory(httpClient);
		
		return new RestTemplate(factory);	
	}
	
	public String s1Test1() {				
		URI uri = UriComponentsBuilder					
				.fromUriString("http://localhost:8090")
				.path("s2/api/test1")
				.encode()
				.build()
				.toUri();		//uri 생성
		
		//RestTemplate restTemplate = new RestTemplate();
		RestTemplate restTemplate = getRestTemplate();	//get 메소드를 만들고 나선 이렇게 쓸 수 있음
		ResponseEntity<String> responseEntity = restTemplate.getForEntity(uri, String.class);
		
		return responseEntity.getBody();
	}
	
	public String s1Test2(String id, String pwd) {
		URI uri = UriComponentsBuilder					//클라이언트로부터 받은 req를 서버2에 보내주기
				.fromUriString("http://localhost:8090")
				.path("s2/api/test2/{id}/{pwd}")
				.encode()
				.build()
				.expand(id, pwd)	//입력 받은 값 넣기 (@Pathvariable 사용해 값을 전달)
				.toUri();
		
		RestTemplate restTemplate = new RestTemplate();
		
		ResponseEntity<String> responseEntity = restTemplate.getForEntity(uri, String.class);
		
		return responseEntity.getBody();
	}
	
	public String s1Test3(String id, String pwd) {		
		URI uri = UriComponentsBuilder
				.fromUriString("http://localhost:8090")
				.path("s2/api/test3")
				.queryParam("id", id)
				.queryParam("pwd", pwd)		//@RequestParam의 경우 queryParam으로 입력 받은 값 전달받음
				.encode()
				.build()
				.toUri();
		
		RestTemplate restTemplate = new RestTemplate();
		
		ResponseEntity<String> responseEntity = restTemplate.getForEntity(uri, String.class);
		
		return responseEntity.getBody();
	}
	
	public ResponseEntity<MemberDTO> s1Test4(MemberDTO dto) {
		URI uri = UriComponentsBuilder
				.fromUriString("http://localhost:8090")
				.path("s2/api/test4")
				.queryParam("name", dto.getName())				//queryparam으로 dto 값 넘겨주기
				.queryParam("email", dto.getEmail())
				.queryParam("organization", dto.getOrganization())	
				.encode()
				.build()
				.toUri();
		
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<MemberDTO> responseEntity 
			= restTemplate.postForEntity(uri, dto, MemberDTO.class);
		
		return responseEntity;
	}
	
	public ResponseEntity<MemberDTO> s1Test5(MemberDTO dto) {
		URI uri = UriComponentsBuilder
				.fromUriString("http://localhost:8090")
				.path("s2/api/test5")
				.encode()			//encode("UTF-8")과 동일
				.build()
				.toUri();
		
		RequestEntity<MemberDTO> requestEntity 	//requestEntity 생성
			= 	RequestEntity.post(uri)
				.header("my-header", "test-api")	//이런식으로 헤더를 달 수 있음
				.body(dto);							//body에 dto 넘겨주기
		
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<MemberDTO> responseEntity 
			= restTemplate.exchange(requestEntity, MemberDTO.class);//이렇게 해서 이번엔 진짜로 dto 보내보기
		
		return responseEntity;
	}
}
