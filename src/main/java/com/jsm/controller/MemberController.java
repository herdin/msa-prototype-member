package com.jsm.controller;

import com.jsm.dto.model.MemberModel;
import com.jsm.service.MemberService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sun.jvm.hotspot.debugger.linux.aarch64.LinuxAARCH64CFrame;

import java.util.List;

@RestController
public class MemberController {
    Logger logger = LoggerFactory.getLogger(MemberController.class);

    @Autowired
    MemberService memberService;

    // 전체회원목록조회
    @GetMapping("/member")
    public ResponseEntity<List<MemberModel>> readMemberList(){
        List<MemberModel> list = memberService.readMemberList();

        if(list == null){
            return ResponseEntity.badRequest().body(list);
        }

        return ResponseEntity.ok().body(list);
    }

    // 특정회원조회
    @GetMapping("/member/{userId}")
    public MemberModel readMemberInfo(@PathVariable int userId){
        MemberModel memberModel = memberService.readMemberInfo(userId);
        return memberModel;
    }

    // 회원등록
    @PutMapping("/member")
    public ResponseEntity<Integer> addMember(@PathVariable MemberModel memberModel ){
        int cnt = memberService.addMember(memberModel);

        if(cnt == 0){
            return ResponseEntity.ok(cnt);
        }else{
            return ResponseEntity.badRequest().body(cnt);
        }
    }

    // 회원수정
    @PostMapping("/member")
    public ResponseEntity<Integer> updateMember(@PathVariable MemberModel memberModel ){
        int cnt = memberService.updateMember(memberModel);

        if(cnt == 0){
            return ResponseEntity.ok(cnt);
        }else{
            return ResponseEntity.badRequest().body(cnt);
        }
    }

    // 회원삭제
    @PostMapping("/member")
    public ResponseEntity<Integer> deleteMember(@PathVariable int userId ){
        int cnt = memberService.deleteMember(userId);

        if(cnt == 0){
            return ResponseEntity.ok(cnt);
        }else{
            return ResponseEntity.badRequest().body(cnt);
        }
    }
}