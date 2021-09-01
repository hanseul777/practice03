package org.zerock.practice03.board.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan(basePackages = "org.zerock.practice03.board.mapper")
@ComponentScan(basePackages = "org.zerock.practice03.board.service")
public class BoardRootConfig {
}
