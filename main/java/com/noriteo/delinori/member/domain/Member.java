package com.noriteo.delinori.member.domain;

import com.noriteo.delinori.member.dto.MemberDTO;
import lombok.*;

@Getter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Member {

    private String mid, mname, mpw, maddress, memail, mphone;
    private boolean enable;

    public MemberDTO getDTO() {
        MemberDTO memberDTO= MemberDTO.builder()
                .mid(mid)
                .mname(mname)
                .mpw(mpw)
                .maddress(maddress)
                .memail(memail)
                .mphone(mphone)
                .enable(enable)
                .build();

        return memberDTO;
    }

    public void setMid(String mid) {
        this.mid=mid;
    }

}
