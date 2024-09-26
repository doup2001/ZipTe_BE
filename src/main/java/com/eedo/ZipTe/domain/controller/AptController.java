package com.eedo.ZipTe.domain.controller;

import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@RestController
@RequiredArgsConstructor
@Log4j2
@RequestMapping("/api/apt")
public class AptController {

    // RestTemplate Bean 생성 (또는 @Autowired로 주입할 수 있음)
    private final RestTemplate restTemplate = new RestTemplate();

    @GetMapping("/get")
    public Map<String, Object> getOne(@RequestParam String apartment_name) {
        log.info("[Log] apartment_name: " + apartment_name);

        String url = "http://localhost:5001/get-code?apartment_name=" + apartment_name;

        // API 요청 보내고 응답 받기
        ResponseEntity<Map> response = restTemplate.getForEntity(url, Map.class);

        // 받은 응답을 그대로 클라이언트에 반환
        return response.getBody();
    }

    @GetMapping("/getTransaction")
    public Map<String, Object> getMany(@RequestParam String region_name,@RequestParam int DEAL_YMD, @RequestParam int pageNo, @RequestParam int numOfRows) {
        log.info("[Log] parameters: " + region_name+ DEAL_YMD,pageNo,numOfRows);

        String url = "http://localhost:5001/get_apartment_data?region_name="+region_name+"&DEAL_YMD="+DEAL_YMD+"=&pageNo="+pageNo+"&numOfRows="+numOfRows;

        // API 요청 보내고 응답 받기
        ResponseEntity<Map> response = restTemplate.getForEntity(url, Map.class);

        // 받은 응답을 그대로 클라이언트에 반환
        return response.getBody();
    }


}
