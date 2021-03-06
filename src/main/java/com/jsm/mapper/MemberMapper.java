package com.jsm.mapper;

import com.jsm.dto.model.MemberModel;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface MemberMapper {
    // 전체회원목록조회
    //List<MemberModel> readMemberList();

    // 로그인
    MemberModel login(String userId, String password);

    // 특정회원조회
    MemberModel getMember(String userId);

    // 회원가입
    int addMember(MemberModel memberModel);

    // 회원수정
    int updateMember(MemberModel memberModel);

    // 회원삭제
    int deleteMember(String userId);
}