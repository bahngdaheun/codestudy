package com.noriteo.delinori.member.dto;

import com.noriteo.delinori.member.domain.Member;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MemberDTO {

    private String mid;
    private String mname;
    private String mpw;
    private String maddress;
    private String memail;
    private String mphone;
    private boolean enable;

    public Member getDomain() {
        Member member= Member.builder()
                .mid(mid)
                .mname(mname)
                .mpw(mpw)
                .maddress(maddress)
                .memail(memail)
                .mphone(mphone)
                .enable(enable)
                .build();

        return member;
    }

}
