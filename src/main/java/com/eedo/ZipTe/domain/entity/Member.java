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
    private Address address;

    @Builder.Default
    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<Owner> apartments = new ArrayList<>();

    @Enumerated(EnumType.STRING)
    private MemberRole memberRole;
}
