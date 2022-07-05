package com.ultraneos.mall.model.po;

import lombok.Data;

/**
 * @author Saitama
 * @since 2022/06/28 13:15
 */
@Data
public class Admin {
    private Integer id;
    private String username;
    private String password;
    private String nickname;

    public Admin(Integer id, String username, String password, String nickname) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.nickname = nickname;
    }

    public Admin() {
    }
}
