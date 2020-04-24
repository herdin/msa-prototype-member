package com.jsm.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class MemberControllerTest {
    Logger logger = LoggerFactory.getLogger(MemberControllerTest.class);

    @Autowired
    MockMvc mockMvc;

    @Test
    public void getUser() throws Exception{
        int userid = 1;
        mockMvc.perform(MockMvcRequestBuilders.get("/member/" + userid))
                .andDo(print())
                .andExpect(status().isOk())
        ;
    }
}