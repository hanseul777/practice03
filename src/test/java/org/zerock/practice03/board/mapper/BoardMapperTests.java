package org.zerock.practice03.board.mapper;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.zerock.practice03.board.config.BoardRootConfig;
import org.zerock.practice03.board.domain.Board;
import org.zerock.practice03.common.config.RootConfig;

import java.util.stream.IntStream;

@Log4j2
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {BoardRootConfig.class, RootConfig.class})
public class BoardMapperTests {

    @Autowired
    BoardMapper boardMapper;

    @Test
    public void testDummies(){

        IntStream.rangeClosed(1,100).forEach(i -> {
            Board board = Board.builder()
                    .title("title" + i)
                    .content("content" + i)
                    .writer("user" + (i % 10))
                    .build();

            boardMapper.insert(board);

        });
    }

    @Test
    public void testList(){
        boardMapper.getList().forEach(board -> log.info(board));
    }

    @Test
    public void testSelect(){

        log.info(boardMapper.select(112L));
    }

    @Test
    public void testDelete(){
        Long bno = 110L;
        log.info("delete.............................................");
        log.info(boardMapper.delete(bno));
    }

    @Test
    public void testUpdate(){
        Board board = Board.builder()
                .bno(108L)
                .title("mapperTest")
                .content("test")
                .build();
        log.info("update................");
        log.info(boardMapper.update(board));
    }
}

