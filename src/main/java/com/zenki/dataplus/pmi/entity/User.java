package com.zenki.dataplus.pmi.entity;
import lombok.Data;

import java.util.Date;
import java.io.Serializable;

/**
 * (User)实体类
 *
 * @author makejava
 * @since 2020-08-03 17:18:13
 */
@Data
public class User implements Serializable {
    private static final long serialVersionUID = 497228147365651015L;

    private Integer id;

    private String username;

    private String userPassword;

    private String nickname;

    private String email;

    private String phonenum;

    private String sex;

    private String address;

    private Date birthday;

    private String isDelete;

    private Date gmt8Created;

    private Date gmt5Modified;


}
