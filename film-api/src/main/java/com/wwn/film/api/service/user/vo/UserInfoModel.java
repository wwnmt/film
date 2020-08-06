package com.wwn.film.api.service.user.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: WeinanWu
 * Date: 2020-07-15
 * Time: 16:32
 */

@Data
public class UserInfoModel implements Serializable {

    private int uuid;

    private String username;

    private String nickname;

    private String email;

    private String phone;

    private int sex;

    private String birthday;

    private int lifeState;

    private String biography;

    private String address;

    private String headAddress;

    private long createTime;

    private long updateTime;
}
