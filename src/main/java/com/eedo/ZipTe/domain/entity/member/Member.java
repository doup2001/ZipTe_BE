package com.eedo.ZipTe.domain.entity.member;

import com.eedo.ZipTe.domain.entity.Address;
import com.eedo.ZipTe.domain.entity.owner.Owner;
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

    @ElementCollection(fetch = FetchType.LAZY)
    @Builder.Default
    private List<MemberRole> memberRoleList = new ArrayList<>();

    public void addRole(MemberRole memberRole) {
        this.memberRoleList.add(memberRole);
    }

    public void clearRole() {
        this.memberRoleList.clear();
    }

    public void changePw(String pw) {
        this.pw = pw;
    }

    public void changeNickName(String nickName) {
        this.nickName = nickName;
    }

    public void changeSocial(boolean social) {
        this.social = social;
    }
}
