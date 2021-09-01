package org.zerock.practice03.board.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.zerock.practice03.board.mapper.TimeMapper;

@Service
@Log4j2
@RequiredArgsConstructor
public class TimeServiceImpl implements TimeService{

    private final TimeMapper timeMapper;

    @Override
    public String getNow() {

        log.info("service.............getNow()");
        return timeMapper.getTime2();
    }
}

