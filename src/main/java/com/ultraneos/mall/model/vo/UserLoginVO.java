package com.ultraneos.mall.model.vo;

/**
 * @author Saitama
 * @since 2022/06/30 10:30
 */

public class UserLoginVO {


    /**
     * code : 0
     * name : admin
     * token : admin
     */
    private int code;
    private String name;
    private String token;

    public UserLoginVO(int code, String name, String token) {
        this.code = code;
        this.name = name;
        this.token = token;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public int getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public String getToken() {
        return token;
    }
}
