package com.itany.entity;

import java.io.Serializable;
import java.util.Date;

public class User implements Serializable {
    private static final long serialVersionUID = 1L;

    private ServerCompany serverCompany;

    private Integer id;

    private String name;

    private String password;

    private String nickname;

    private String phone;

    private String wechat;

    private String qq;

    private String headimg;

    private Integer sex;

    private Integer companyid;

    private Integer flag;

    private Date createdate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname == null ? null : nickname.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getWechat() {
        return wechat;
    }

    public void setWechat(String wechat) {
        this.wechat = wechat == null ? null : wechat.trim();
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq == null ? null : qq.trim();
    }

    public String getHeadimg() {
        return headimg;
    }

    public void setHeadimg(String headimg) {
        this.headimg = headimg == null ? null : headimg.trim();
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Integer getCompanyid() {
        return companyid;
    }

    public void setCompanyid(Integer companyid) {
        this.companyid = companyid;
    }

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    public ServerCompany getServerCompany() {
        return serverCompany;
    }

    public void setServerCompany(ServerCompany serverCompany) {
        this.serverCompany = serverCompany;
    }

    @Override
    public String toString() {
        return "User{" +
                "serverCompany=" + serverCompany +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", nickname='" + nickname + '\'' +
                ", phone='" + phone + '\'' +
                ", wechat='" + wechat + '\'' +
                ", qq='" + qq + '\'' +
                ", headimg='" + headimg + '\'' +
                ", sex=" + sex +
                ", companyid=" + companyid +
                ", flag=" + flag +
                ", createdate=" + createdate +
                '}';
    }
}