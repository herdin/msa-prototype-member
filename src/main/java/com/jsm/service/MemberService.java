package com.jsm.service;

import com.jsm.dto.model.MemberModel;

import java.util.List;

public interface MemberService {
    // 전체회원목록조회
    public List<MemberModel> readMemberList();

    // 특정회원조회
    public MemberModel readMemberInfo(int userid);
}
