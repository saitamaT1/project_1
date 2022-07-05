package com.ultraneos.mall.model.bo;

/**
 * @author Saitama
 * @since 2022/06/28 18:29
 */

public class AdminSearchBO {

    /**
     * nickname :
     * email : a
     */
    private String nickname;
    private String email;

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNickname() {
        return nickname;
    }

    public String getEmail() {
        return email;
    }
}
