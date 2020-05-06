package com.jsm.controller;

import com.jsm.dto.model.MemberModel;
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

    // 전체회원목록조회(정상)
    @Test
    public void 전체회원목록조회_정상() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.get("/memberList"))
                .andDo(print())
                .andExpect(status().isOk())
        ;
    }

    // 전체회원목록조회(비정상)
    /*@Test
    public void 전체회원목록조회_비정상() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.get("/memberList"))
                .andDo(print())
                .andExpect(status().isBadRequest())
        ;
    }*/

    // 특정회원조회_정상
    @Test
    public void 특정회원조회_정상() throws Exception {
        int userid = 1;
        mockMvc.perform(MockMvcRequestBuilders.get("/member/" + userid))
                .andDo(print())
                .andExpect(status().isOk())
        ;
    }

    // 특정회원조회_비정상
    /*@Test
    public void 특정회원조회_비정상() throws Exception {
        int userid = 2;
        mockMvc.perform(MockMvcRequestBuilders.get("/member/" + userid))
                .andDo(print())
                .andExpect(status().isBadRequest())
        ;
    }*/

    // 회원가입
    @Test
    public void addMember() throws Exception {
        MemberModel memberModel = new MemberModel();
        memberModel.setUserid(2);
        memberModel.setUsername("Jo");

        mockMvc.perform(MockMvcRequestBuilders.get("/member/add" + memberModel))
                .andDo(print())
                .andExpect(status().isOk())
        ;
    }
}