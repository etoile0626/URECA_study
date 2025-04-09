package kr.co.ureca.emp.service;

import java.net.URI;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.hc.client5.http.config.ConnectionConfig;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.HttpClientBuilder;
import org.apache.hc.client5.http.impl.io.PoolingHttpClientConnectionManager;
import org.apache.hc.client5.http.impl.io.PoolingHttpClientConnectionManagerBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import kr.co.ureca.dto.EmpDTO;

@Service
public class EmpService {

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
	
	public List<EmpDTO> empFindAll(){
		
		URI uri = UriComponentsBuilder
					.fromUriString("http://localhost:8083")
					.path("/emp/list")
					.encode()
					.build()
					.toUri();
		
		RestTemplate restTemplate = getRestTemplate();
		ResponseEntity<List> responseEntity 
			= restTemplate.getForEntity(uri, List.class);
		
		return responseEntity.getBody();
		
	}

	public EmpDTO empFindById(Long id) {
		
		URI uri = UriComponentsBuilder
				.fromUriString("http://localhost:8083")
				.path("/emp/detail/{id}")
				.encode()
				.build()
				.expand(id)
				.toUri();
		
		RestTemplate restTemplate = getRestTemplate();
		
		ResponseEntity<EmpDTO> responseEntity = restTemplate.getForEntity(uri, EmpDTO.class);
		
		return responseEntity.getBody();
	}

	public EmpDTO empInsert(EmpDTO dto) {
		
		URI uri = UriComponentsBuilder
				.fromUriString("http://localhost:8083")
				.path("/emp/insert")
				.encode()
				.build()
				.toUri();
	
		RestTemplate restTemplate = getRestTemplate();
																				//보낼 객체, 보낼 객체 타입
		ResponseEntity<EmpDTO> responseEntity = restTemplate.postForEntity(uri, dto, EmpDTO.class);
	
		return responseEntity.getBody();
	}
}
