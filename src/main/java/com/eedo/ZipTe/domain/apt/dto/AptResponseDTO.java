package com.eedo.ZipTe.domain.apt.dto;

import lombok.Data;

import java.util.List;

@Data
public class AptResponseDTO {

    // 철근콘크리트구조"
    private String codeStr;
    //""관공서(성남시청) 병원(한빛치과) 대형상가(삼성디지털프라자) 기타(분당고속버스터미널)",
    private List<String> convenientFacility;
    // 초등학교(야탑초등교) 중학교(야탑중교)",
    private List<String> educationFacility;
    //A46378823
    private int kaptCode;
    private String kaptdWtimebus;
    private String kaptdWtimesub;
    private String subwayLine;
    private String subwayStation;
    private String kaptName;

}
