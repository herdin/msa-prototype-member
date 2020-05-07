package com.jsm.dto.model;

import org.apache.ibatis.type.Alias;

@Alias("Member")
public class MemberModel {
    private String userId;
    private String password;
    private String userName;
    private String useYn;
    private String rgtDtm;
    private String updDtm;

    public MemberModel(){};

    public MemberModel(String userId, String password, String userName, String useYn, String rgtDtm, String updDtm) {
        this.userId = userId;
        this.password = password;
        this.userName = userName;
        this.useYn = useYn;
        this.rgtDtm = rgtDtm;
        this.updDtm = updDtm;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUseYn() {
        return useYn;
    }

    public void setUseYn(String useYn) {
        this.useYn = useYn;
    }

    public String getRgtDtm() {
        return rgtDtm;
    }

    public void setRgtDtm(String rgtDtm) {
        this.rgtDtm = rgtDtm;
    }

    public String getUpdDtm() {
        return updDtm;
    }

    public void setUpdDtm(String updDtm) {
        this.updDtm = updDtm;
    }

    @Override
    public String toString() {
        return "MemberModel{" +
                "userId='" + userId + '\'' +
                ", password='" + password + '\'' +
                ", userName='" + userName + '\'' +
                ", useYn='" + useYn + '\'' +
                ", rgtDtm='" + rgtDtm + '\'' +
                ", updDtm='" + updDtm + '\'' +
                '}';
    }
}