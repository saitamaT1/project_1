package com.ultraneos.mall.model.bo;

/**
 * @author Saitama
 * @since 2022/06/28 16:43
 */

public class AdminAddBO {

    /**
     * nickname : QWe123123
     * pwd : QWe123123@
     * email : 123123@qq.com
     */
    private String nickname;
    private String pwd;
    private String email;

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNickname() {
        return nickname;
    }

    public String getPwd() {
        return pwd;
    }

    public String getEmail() {
        return email;
    }
}
