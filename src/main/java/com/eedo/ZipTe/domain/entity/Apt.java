package com.eedo.ZipTe.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Apt {

    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY) // 기본 키 전략 추가
    private Long code;

    private String aptName;

    @Embedded
    private Address address;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @Builder.Default
    @OneToMany(mappedBy = "apt")
    private List<Review> reviewList = new ArrayList<>();

    @Embedded
    private ResidenceType type;

}
