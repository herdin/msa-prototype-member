package com.jsm.mapper;

import com.jsm.dto.model.MemberModel;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface MemberMapper {
    // 전체회원목록조회
    List<MemberModel> readMemberList();

    // 특정회원조회
    MemberModel readMemberInfo(int userid);

    // 회원가입
   // int addMember(MemberModel memberModel);
}