package com.ultraneos.mall.model.vo;

/**
 * @author Saitama
 * @since 2022/06/28 15:47
 */

public class AdminInfoVO {

    /**
     * nickname : admin
     * id : 1
     * pwd : admin
     * email : admin
     */
    private String nickname;
    private Integer id;
    private String pwd;
    private String email;

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Integer getId() {
        return id;
    }

    public String getPwd() {
        return pwd;
    }

    public String getEmail() {
        return email;
    }
}
