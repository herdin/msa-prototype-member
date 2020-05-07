package com.jsm.service;

import com.jsm.dto.model.MemberModel;
import com.jsm.mapper.MemberMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberServiceImpl implements MemberService{
    @Autowired
    MemberMapper memberMapper;

    // 전체회원목록조회
    /*public List<MemberModel> readMemberList(){
        return memberMapper.readMemberList();
    }*/

    // 특정회원조회
    public MemberModel getMember(String userId) {
        return memberMapper.getMember(userId);
    }

    // 회원가입
    public int addMember(MemberModel memberModel){
        return memberMapper.addMember(memberModel);
    }

    // 회원수정
    public int updateMember(MemberModel memberModel){
        return memberMapper.updateMember(memberModel);
    }

    // 회원삭제
    public int deleteMember(String userid){
        return memberMapper.deleteMember(userid);
    }
}
