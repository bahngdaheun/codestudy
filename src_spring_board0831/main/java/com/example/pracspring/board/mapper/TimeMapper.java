package com.example.pracspring.board.mapper;

import org.apache.ibatis.annotations.Select;

public interface TimeMapper {//DB에서 가져옴(DAO 비슷한 역할), DB와 연결

    @Select("select now()")
    String getTime();

    String getTime2();
}
