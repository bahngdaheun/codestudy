package com.noriteo.delinori_front.dto;

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

    @Builder.Default
    private boolean enable=true;

    @Builder.Default
    private boolean delifile=false;

    @Builder.Default
    private int replyCnt=0;

    @Builder.Default
    private String show="y";
}
