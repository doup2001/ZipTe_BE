package com.eedo.ZipTe.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Apt {

    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY) // 기본 키 전략 추가
    private Long bidCode;

    private String doroJuso;

    private String kaptName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;


}
