package com.jsm.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jsm.dto.model.MemberModel;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
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

    @Autowired
    private ObjectMapper objectMapper;

    // 전체회원목록조회(정상)
  /*  @Test
    public void 전체회원목록조회_정상() throws Exception{
        int userId = 1000000006;

        mockMvc.perform(MockMvcRequestBuilders.get("/member")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(userId))
        )
                .andDo(print())
                .andExpect(status().isOk())
        ;
    }*/

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
        String userId = "soonmin.jang";
        mockMvc.perform(MockMvcRequestBuilders.get("/member/" + userId))
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
    //@Test
    public void addMember() throws Exception {
        MemberModel memberModel = new MemberModel();
        memberModel.setUserId("soonmin.jang");
        memberModel.setPassword("1q2w3e4r");
        memberModel.setUserName("soon");
        memberModel.setUseYn("Y");
        memberModel.setRgtDtm("20200504180400");
        memberModel.setUpdDtm("20200504180400");

        mockMvc.perform(MockMvcRequestBuilders.put("/member")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(memberModel))
        )
                .andDo(print())
                .andExpect(status().isOk())
        ;
    }

    // 회원수정
    //@Test
    public void updateMember() throws Exception {
        MemberModel memberModel = new MemberModel();
        memberModel.setUserId("sm.jang0302");
        memberModel.setUserName("Joa");

        mockMvc.perform(MockMvcRequestBuilders.post("/member")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(memberModel))
        )
                .andDo(print())
                .andExpect(status().isOk())
        ;
    }

    //@Test
    public void deleteMember() throws Exception {
        MemberModel memberModel = new MemberModel();
        memberModel.setUserId("");
        String userId = "sm.jang0302";

        mockMvc.perform(MockMvcRequestBuilders.delete("/member")
                .contentType(MediaType.APPLICATION_JSON)
                .content(userId)
        )
                .andDo(print())
                .andExpect(status().isOk())
        ;
    }

    //@Test
    public void login() throws Exception {
        String userId = "soonmin.jang";
        String password = "72ab994fa2eb426c051ef59cad617750bfe06d7cf6311285ff79c19c32afd236";

        mockMvc.perform(MockMvcRequestBuilders.post("/member/login/" + userId + "/" + password))
                .andDo(print())
                .andExpect(status().isOk())
        ;
    }
}