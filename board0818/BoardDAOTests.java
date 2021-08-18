package org.zerock.board.dao;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.zerock.board.dto.BoardDTO;

@Log4j2
public class BoardDAOTests {
@Test
    public void testSelect() {
    log.info(BoardDAO.INSTANCE.select());
}

@Test
    public void testRead() {
    int bno=3;
    log.info(BoardDAO.INSTANCE.read(bno));
}

@Test
    public void testInsert() {
    String title="제목1입니다";
            String writer="작성자1입니다";
            String content="내용1입니다";
    BoardDTO boardDTO=BoardDTO.builder().title(title)
            .writer(writer).content(content).build();
    BoardDAO.INSTANCE.insert(boardDTO);
}

}
