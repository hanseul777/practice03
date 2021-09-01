package org.zerock.practice03.board.mapper;

import lombok.extern.log4j.Log4j2;
import org.zerock.practice03.board.domain.Board;
import org.zerock.practice03.board.dto.BoardDTO;

import java.util.List;

public interface BoardMapper {

    void insert(Board board);

    List<Board> getList();

    Board select(Long bno);

    int delete(Long bno);

    int update(Board board);
}
