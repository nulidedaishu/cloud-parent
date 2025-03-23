package com.itany.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.itany.vo.UserStats;
import org.springframework.format.annotation.DateTimeFormat;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ServerCompany {
    private static final long serialVersionUID = 1L;

    private User user;
    private MemberCompany memberCompany;
    private Member member;
    private UserStats userStats;

    public UserStats getUserStats() {
        return userStats;
    }

    public void setUserStats(UserStats userStats) {
        this.userStats = userStats;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public MemberCompany getMemberCompany() {
        return memberCompany;
    }

    public void setMemberCompany(MemberCompany memberCompany) {
        this.memberCompany = memberCompany;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    @Override
    public String toString() {
        return "ServerCompany{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", info='" + info + '\'' +
                ", address='" + address + '\'' +
                ", gps='" + gps + '\'' +
                ", scale='" + scale + '\'' +
                ", createdate=" + createdate +
                ", joindate=" + joindate +
                ", flag=" + flag +
                ", type=" + type +
                ", linkman='" + linkman + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }

    private Integer id;

    private String name;//服务公司名称

    private String info;//服务公司简介

    private String address;//地址

    private String gps;//坐标

    private String scale;//规模

    @JSONField(format = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date createdate;//成立日期

    @JSONField(format = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date joindate;//入驻日期

    private Integer flag;//状态

    private Integer type;//生活1/商务服务2

    private String linkman;//联系人

    private String phone;//公司电话

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

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info == null ? null : info.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getGps() {
        return gps;
    }

    public void setGps(String gps) {
        this.gps = gps == null ? null : gps.trim();
    }

    public String getScale() {
        return scale;
    }

    public void setScale(String scale) {
        this.scale = scale == null ? null : scale.trim();
    }


    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    public Date getJoindate() {
        return joindate;
    }

    public void setJoindate(Date joindate) {
        this.joindate = joindate;
    }

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getLinkman() {
        return linkman;
    }

    public void setLinkman(String linkman) {
        this.linkman = linkman == null ? null : linkman.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }
}