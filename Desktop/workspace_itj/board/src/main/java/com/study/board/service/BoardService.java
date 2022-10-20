package com.study.board.service;

import com.study.board.entity.Board;
import com.study.board.repository.BoardRepositoy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardService {
    @Autowired
    private BoardRepositoy boardRepositoy;

    public void write(Board board) {
        boardRepositoy.save(board);
    }

    public List<Board> boardList() {
        return boardRepositoy.findAll();
    }
}
