package com.study.board.service;

import com.study.board.entity.Board;
import com.study.board.repository.BoardRepositoy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.List;
import java.util.UUID;

@Service
public class BoardService {
    @Autowired
    private BoardRepositoy boardRepositoy;

    public void write(Board board, MultipartFile file) throws Exception {
        String projectPath = System.getProperty("user.dir") + "/src/main/webapp/";

        UUID uuid = UUID.randomUUID();
        String fileName = uuid + "_" + file.getOriginalFilename();
        File saveFile = new File(projectPath, fileName);
        file.transferTo(saveFile);
        board.setFilename(fileName);
        board.setFilepath("/webapp/" + fileName);
        boardRepositoy.save(board);
    }

    public List<Board> boardList() {
        return boardRepositoy.findAll();
    }

    public Board boardView(Integer id) {
        return boardRepositoy.findById(id).get();
    }

    public void boardDelete(Integer id) {
        boardRepositoy.deleteById(id);
    }

}
