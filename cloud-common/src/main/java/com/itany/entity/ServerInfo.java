package com.itany.entity;

import com.alibaba.fastjson.annotation.JSONField;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class ServerInfo implements Serializable {
    private static final long serialVersionUID = 1L;

    private ServerCompany serverCompany;
    private List<Type> types;
    private User user;
    private Member member;
    private List<Area> areas;

    private Integer id;

    private String servername;

    private String info;

    private String linkman;

    private String phone;

    private Integer userid;

    private Integer companyid;

    @JSONField(format = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date createdate;

    private Integer flag;

    private BigDecimal price;

    public String getServiceRange() {
        if (types == null || types.isEmpty()) {
            return "";
        }
        StringBuilder serviceRange = new StringBuilder();
        for (Type type : types) {
            if (serviceRange.length() > 0) {
                serviceRange.append("、");
            }
            serviceRange.append(type.getName());
        }
        return serviceRange.toString();
    }

    public List<Integer> getServiceTypeIds() {
        if (types == null || types.isEmpty()) {
            return Collections.emptyList();
        }
        return types.stream()
                .map(Type::getId)
                .collect(Collectors.toList());
    }

    public String getServiceAreas() {
        if (areas == null || areas.isEmpty()) {
            return "";
        }
        StringBuilder serviceAreas = new StringBuilder();
        for (Area area : areas) {
            if (serviceAreas.length() > 0) {
                serviceAreas.append("、");
            }
            serviceAreas.append(area.getName());
        }
        return serviceAreas.toString();
    }

    public List<Integer> getServiceAreaIds() {
        if (areas == null || areas.isEmpty()) {
            return Collections.emptyList();
        }
        return areas.stream()
                .map(Area::getId)
                .collect(Collectors.toList());
    }

    public void setServiceTypeIds(List<Integer> ids) {
        this.types = ids.stream()
                .map(id -> {
                    Type type = new Type();
                    type.setId(id);
                    return type;
                })
                .collect(Collectors.toList());
    }

    public void setServiceAreaIds(List<Integer> ids) {
        this.areas = ids.stream()
                .map(id -> {
                    Area area = new Area();
                    area.setId(id);
                    return area;
                })
                .collect(Collectors.toList());
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getServername() {
        return servername;
    }

    public void setServername(String servername) {
        this.servername = servername == null ? null : servername.trim();
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info == null ? null : info.trim();
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

    public Integer getCompanyid() {
        return companyid;
    }

    public void setCompanyid(Integer companyid) {
        this.companyid = companyid;
    }

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public ServerCompany getServerCompany() {
        return serverCompany;
    }

    public void setServerCompany(ServerCompany serverCompany) {
        this.serverCompany = serverCompany;
    }

    public List<Type> getTypes() {
        return types;
    }

    public void setTypes(List<Type> types) {
        this.types = types;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public List<Area> getAreas() {
        return areas;
    }

    public void setAreas(List<Area> areas) {
        this.areas = areas;
    }


    @Override
    public String toString() {
        return "ServerInfo{" +
                "serverCompany=" + serverCompany +
                ", types=" + types +
                ", user=" + user +
                ", member=" + member +
                ", areas=" + areas +
                ", id=" + id +
                ", servername='" + servername + '\'' +
                ", info='" + info + '\'' +
                ", linkman='" + linkman + '\'' +
                ", phone='" + phone + '\'' +
                ", userid=" + userid +
                ", companyid=" + companyid +
                ", createdate=" + createdate +
                ", flag=" + flag +
                ", price=" + price +
                '}';
    }
}