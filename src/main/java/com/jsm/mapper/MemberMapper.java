package com.jsm.mapper;

import com.jsm.dto.model.MemberModel;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface MemberMapper {
    List<MemberModel> readAllMemberInfo();
    int addMember(MemberModel memberModel);
    int readMaxMemberId();
}