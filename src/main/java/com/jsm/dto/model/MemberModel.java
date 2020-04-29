package com.jsm.dto.model;

import org.apache.ibatis.type.Alias;

@Alias("Member")
public class MemberModel {
    private int userid;
    private String username;
    public MemberModel(){}
    public MemberModel(int userid, String userName) {
        this.userid = userid;
        this.username = userName;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "MemberModel{" +
                "userid=" + userid +
                ", username='" + username + '\'' +
                '}';
    }
}
