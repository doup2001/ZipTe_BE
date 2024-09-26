package com.eedo.ZipTe.domain.entity.owner;

import com.eedo.ZipTe.domain.entity.apt.Apt;
import com.eedo.ZipTe.domain.entity.member.Member;
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
