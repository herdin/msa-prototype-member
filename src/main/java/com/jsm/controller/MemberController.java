package com.jsm.controller;

import com.jsm.dto.model.MemberModel;
import com.jsm.service.MemberService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class MemberController {
    Logger logger = LoggerFactory.getLogger(MemberController.class);

    @Autowired
    MemberService memberService;

    // 회원조회
    /*@CrossOrigin
    @GetMapping("/member")
    public ResponseEntity<List<MemberModel>> readMemberList(){
        List<MemberModel> list = memberService.readMemberList();

        if(list == null){
            return ResponseEntity.badRequest().body(list);
        }

        return ResponseEntity.ok().body(list);
    }*/
    
    // 로그인
    @CrossOrigin
    @PostMapping("/member/login/{userId}/{password}")
    public ResponseEntity login(@PathVariable String userId, @PathVariable String password){
        ResponseEntity res = memberService.login(userId, password);

        return res;
    }

    // 특정회원조회
    @CrossOrigin
    @GetMapping("/member/{userId}")
    public ResponseEntity<MemberModel> getMember(@PathVariable String userId){
        MemberModel memberModel = memberService.getMember(userId);

        if(memberModel == null){
            return ResponseEntity.badRequest().body(null);
        }

        return ResponseEntity.ok().body(memberModel);
    }

    // 회원등록
    @CrossOrigin
    @PutMapping("/member")
    public ResponseEntity<Integer> addMember(@RequestBody MemberModel memberModel ) throws Exception {
        int cnt = memberService.addMember(memberModel);

        if(cnt != 0){
            return ResponseEntity.ok(cnt);
        }else{
            return ResponseEntity.badRequest().body(cnt);
        }
    }

    // 회원수정
    @CrossOrigin
    @PostMapping("/member")
    public ResponseEntity<Integer> updateMember(@RequestBody MemberModel memberModel ){
        int cnt = memberService.updateMember(memberModel);

        if(cnt != 0){
            return ResponseEntity.ok(cnt);
        }else{
            return ResponseEntity.badRequest().body(cnt);
        }
    }

    // 회원삭제
    @CrossOrigin
    @DeleteMapping("/member")
    public ResponseEntity<Integer> deleteMember(@RequestBody String userId){
        int cnt = memberService.deleteMember(userId);

        if(cnt != 0){
            return ResponseEntity.ok(cnt);
        }else{
            return ResponseEntity.badRequest().body(cnt);
        }
    }
}