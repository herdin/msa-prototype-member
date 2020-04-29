package com.jsm.service;

import com.jsm.dto.model.MemberModel;
import com.jsm.mapper.MemberMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberServiceImpl implements MemberService{
    @Autowired
    MemberMapper memberMapper;

    // 전체회원목록조회
    public List<MemberModel> readMemberList(){
        return memberMapper.readMemberList();
    }

    // 특정회원조회
    public MemberModel readMemberInfo(int userid) {
        return memberMapper.readMemberInfo(userid);
    }
}
