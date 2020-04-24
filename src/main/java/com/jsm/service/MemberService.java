package com.jsm.service;

import com.jsm.dto.model.MemberModel;
import com.jsm.mapper.MemberMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberService {
    @Autowired
    MemberMapper memberMapper;
    public int readMaxMemberId(){
        return memberMapper.readMaxMemberId();
    }

    public boolean addMember(MemberModel memberModel) {
        memberMapper.addMember(memberModel);

        return true;
    }
}
