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
public class Member {

    @Id
    private String email;

    private String pw;

    private String nickName;

    private boolean social;

    @Embedded
    private Address Address;

    @Builder.Default
    @OneToMany(mappedBy = "member")
    private List<Apt> apartments = new ArrayList<>();


}
