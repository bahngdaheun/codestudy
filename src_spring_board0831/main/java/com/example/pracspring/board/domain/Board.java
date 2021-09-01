package com.example.pracspring.board.domain;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Board {

    private Long bno;
    private String title, content, writer;
    private LocalDateTime regDate, modDate;

}
