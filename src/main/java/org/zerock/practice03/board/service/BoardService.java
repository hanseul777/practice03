package org.zerock.practice03.board.service;

import org.zerock.practice03.board.dto.BoardDTO;

import java.util.List;

public interface BoardService {

    Long register(BoardDTO boardDTO);

    List<BoardDTO> getDTOList();

    BoardDTO read(Long bno);

    boolean remove(Long bno);

    boolean modify(BoardDTO boardDTO);
}
