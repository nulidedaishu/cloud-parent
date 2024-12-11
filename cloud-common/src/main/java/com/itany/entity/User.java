package com.itany.entity;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class User implements Serializable{

    private Integer id;

    private String username;

    private String password;

    private String  status;
  
    private String phone;

    @JSONField(format="yyyy-MM-dd")
    private Date createDate;

}
