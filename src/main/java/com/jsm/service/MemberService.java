package com.jsm.service;

import com.jsm.dto.model.MemberModel;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface MemberService {
    // 전체회원목록조회
    public List<MemberModel> readMemberList();

    // 특정회원조회
    //public MemberModel readMemberInfo(int userId);

    // 회원가입
    public int addMember(MemberModel memberModel);

    // 회원수정
    public int updateMember(MemberModel memberModel);

    // 회원삭제
    public int deleteMember(int userId);
}
