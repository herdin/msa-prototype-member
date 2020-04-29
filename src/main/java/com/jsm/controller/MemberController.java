package com.jsm.controller;

import com.jsm.dto.model.MemberModel;
import com.jsm.service.MemberService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MemberController {
    Logger logger = LoggerFactory.getLogger(MemberController.class);

    @Autowired
    MemberService memberService;

    // 전체회원목록조회
    @GetMapping("/member")
    public List<MemberModel> readMemberList(){
        List<MemberModel> list = memberService.readMemberList();

        return list;
    }

    // 특정회원조회
    @GetMapping("/member/{userid}")
    public MemberModel readMemberInfo(@PathVariable int userid){
        MemberModel memberModel = memberService.readMemberInfo(userid);
        return memberModel;
    }

    //회원가입
    /*@PostMapping("/member/{userid}/{userName}")
    public ResponseEntity<MemberModel> addUser(@PathVariable  int userid, @PathVariable  String userName) {
        int nextUserId = memberService.readMaxMemberId();

        logger.debug("this is recv -> {}, {}, {}, {}", nextUserId, userName);

        //회원 insert
        boolean isOk = memberService.addMember(new MemberModel(nextUserId, userName));
        if(isOk) {
            MemberModel memberModel = new MemberModel(nextUserId, userName);
            return ResponseEntity.ok(memberModel);
        } else {
            return ResponseEntity.badRequest().body(new MemberModel(nextUserId, userName));
        }*/
    }
//}