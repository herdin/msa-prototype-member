package com.jsm.service;

import com.jsm.dto.model.MemberModel;
import com.jsm.mapper.MemberMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.security.MessageDigest;
import java.util.List;

@Service
public class MemberServiceImpl implements MemberService{
    @Autowired
    MemberMapper memberMapper;

    // 전체회원목록조회
    /*public List<MemberModel> readMemberList(){
        return memberMapper.readMemberList();
    }*/
    
    // 로그인
    public ResponseEntity login(String userId, String password){
        // 회원ID와 PASSWORD 체크
        MemberModel result = memberMapper.login(userId,password);

        if(result == null || !password.equals(result.getPassword())){
            return ResponseEntity.badRequest().body(null);
        }

        return ResponseEntity.ok(null);
    }

    // 특정회원조회
    public MemberModel getMember(String userId) {
        return memberMapper.getMember(userId);
    }

    // 회원가입
    public int addMember(MemberModel memberModel) throws Exception {
        memberModel.setPassword(getEncSHA256(memberModel.getPassword()));

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

    /**
     * 문자열을 SHA-256 방식으로 암호화
     * @param txt 암호화 하려하는 문자열
     * @return String
     * @throws Exception
     */
    public String getEncSHA256(String txt) throws Exception{
        StringBuffer sbuf = new StringBuffer();

        MessageDigest mDigest = MessageDigest.getInstance("SHA-256");
        mDigest.update(txt.getBytes());

        byte[] msgStr = mDigest.digest() ;

        for(int i=0; i < msgStr.length; i++){
            byte tmpStrByte = msgStr[i];
            String tmpEncTxt = Integer.toString((tmpStrByte & 0xff) + 0x100, 16).substring(1);

            sbuf.append(tmpEncTxt) ;
        }

        return sbuf.toString();
    }
}
