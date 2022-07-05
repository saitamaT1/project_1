package com.ultraneos.mall.model.po;

import lombok.Data;

/**
 * @author Saitama
 * @since 2022/06/29 20:06
 */
@Data
public class User {
    private String address;
    private String phoneNum;
    private String nickname;
    private String recName;
    private Integer id;
    private String password;
    private String name;

    public User(String address, String phoneNum, String nickname, String recName, Integer id, String password, String name) {
        this.address = address;
        this.phoneNum = phoneNum;
        this.nickname = nickname;
        this.recName = recName;
        this.id = id;
        this.password = password;
        this.name = name;
    }

    public User() {
    }

    public User(String name) {
        this.name = name;
    }
}
