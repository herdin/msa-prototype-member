package com.jsm.runner;

import com.jsm.mapper.MemberMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;

@Component
public class PostgreRunner implements ApplicationRunner {
    private Logger logger = LoggerFactory.getLogger(PostgreRunner.class);
    @Autowired
    private MemberMapper memberMapper;
    @Override
    public void run(ApplicationArguments args) throws Exception {
        logger.debug("hello {}", "Jang");
        //logger.debug("read all member info -> {}", memberMapper.readAllMemberInfo());
        //logger.debug("read userid 1 info -> {}", memberMapper.readMemberInfo(1));
        //logger.debug("read all member info -> {}", memberMapper.readMemberList());
    }
}
