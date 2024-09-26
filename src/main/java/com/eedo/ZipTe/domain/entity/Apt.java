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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long code;

    private String aptName;

    @Embedded
    private Address address;

    @Builder.Default
    @OneToMany(mappedBy = "apt", cascade = CascadeType.ALL)
    private List<Review> reviewList = new ArrayList<>();

    @Embedded
    private ResidenceType type;
}
