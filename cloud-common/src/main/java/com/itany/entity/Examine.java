package com.itany.entity;

import com.alibaba.fastjson.annotation.JSONField;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class Examine implements Serializable {
    private static final long serialVersionUID = 1L;

    private User user;

    private Integer id;

    private String title;//审核标题

    private String name;//服务/加盟商名称

    private Integer typeid;//服务类型

    @JSONField(format = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date createdate;//提交日期

    private String linkman;//联系人

    private String phone;//联系电话

    private Integer userid;//申请人ID

    @JSONField(format = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date commpanycreatedate;//服务商成立日期

    private String address;//地址

    private String scale;//规模

    private String gps;//坐标

    private Integer examinetype;//审核类型(1加盟审核,2服务审核)

    private Integer flag;//状态

    private String servertype;//服务范围格式(服务类型ID,服务类型ID..)形式存储

    private String serverarea;//服务地区格式以(地区ID,地区ID...)形式存储

    private String info;//服务商简介/服务简介

    private Integer commpanyid;//若是服务审核则存储发布人所在服务商ID

    private String examineInfo;//备注

    private BigDecimal price;//价格

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getTypeid() {
        return typeid;
    }

    public void setTypeid(Integer typeid) {
        this.typeid = typeid;
    }

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
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

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Date getCommpanycreatedate() {
        return commpanycreatedate;
    }

    public void setCommpanycreatedate(Date commpanycreatedate) {
        this.commpanycreatedate = commpanycreatedate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getScale() {
        return scale;
    }

    public void setScale(String scale) {
        this.scale = scale == null ? null : scale.trim();
    }

    public String getGps() {
        return gps;
    }

    public void setGps(String gps) {
        this.gps = gps == null ? null : gps.trim();
    }

    public Integer getExaminetype() {
        return examinetype;
    }

    public void setExaminetype(Integer examinetype) {
        this.examinetype = examinetype;
    }

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }

    public String getServertype() {
        return servertype;
    }

    public void setServertype(String servertype) {
        this.servertype = servertype == null ? null : servertype.trim();
    }

    public String getServerarea() {
        return serverarea;
    }

    public void setServerarea(String serverarea) {
        this.serverarea = serverarea == null ? null : serverarea.trim();
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info == null ? null : info.trim();
    }

    public Integer getCommpanyid() {
        return commpanyid;
    }

    public void setCommpanyid(Integer commpanyid) {
        this.commpanyid = commpanyid;
    }

    public String getExamineInfo() {
        return examineInfo;
    }

    public void setExamineInfo(String examineInfo) {
        this.examineInfo = examineInfo == null ? null : examineInfo.trim();
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Examine{" +
                "user=" + user +
                ", id=" + id +
                ", title='" + title + '\'' +
                ", name='" + name + '\'' +
                ", typeid=" + typeid +
                ", createdate=" + createdate +
                ", linkman='" + linkman + '\'' +
                ", phone='" + phone + '\'' +
                ", userid=" + userid +
                ", commpanycreatedate=" + commpanycreatedate +
                ", address='" + address + '\'' +
                ", scale='" + scale + '\'' +
                ", gps='" + gps + '\'' +
                ", examinetype=" + examinetype +
                ", flag=" + flag +
                ", servertype='" + servertype + '\'' +
                ", serverarea='" + serverarea + '\'' +
                ", info='" + info + '\'' +
                ", commpanyid=" + commpanyid +
                ", examineInfo='" + examineInfo + '\'' +
                ", price=" + price +
                '}';
    }
}