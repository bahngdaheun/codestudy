package com.example.pracspring.board.service;

import com.example.pracspring.board.domain.Board;
import com.example.pracspring.board.dto.BoardDTO;
import com.example.pracspring.board.mapper.BoardMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@Log4j2
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService{

    private final BoardMapper boardMapper;

    @Override
    public Long register(BoardDTO boardDTO) {
        Board board=boardDTO.getDomain();
        boardMapper.insert(board);
        return board.getBno();
    }
}
