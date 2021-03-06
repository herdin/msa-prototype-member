package com.jsm.service;

import com.jsm.dto.model.MemberModel;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface MemberService {
    // 전체회원목록조회
    //public List<MemberModel> readMemberList();

    // 로그인
    public ResponseEntity login(String userId, String password);

    // 특정회원조회
    public MemberModel getMember(String userId);

    // 회원가입
    public int addMember(MemberModel memberModel) throws Exception;

    // 회원수정
    public int updateMember(MemberModel memberModel);

    // 회원삭제
    public int deleteMember(String userId);
}
