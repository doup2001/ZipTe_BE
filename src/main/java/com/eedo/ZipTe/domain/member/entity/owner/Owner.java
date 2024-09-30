package com.eedo.ZipTe.domain.member.entity.owner;

import com.eedo.ZipTe.domain.apt.entity.Apt;
import com.eedo.ZipTe.domain.member.entity.member.Member;
import jakarta.persistence.*;

@Entity
public class Owner {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "apt_code")
    private Apt apt;

    private OwnerState ownerState;
}
