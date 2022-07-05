package com.ultraneos.mall.model.vo;

/**
 * @author Saitama
 * @since 2022/06/29 21:49
 */

public class UserOfOrdersVO {

    /**
     * address : admin
     * phone : 11111111111
     * nickname : admin
     * name : admin
     */
    private String address;
    private String phone;
    private String nickname;
    private String name;

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    public String getNickname() {
        return nickname;
    }

    public String getName() {
        return name;
    }

    public UserOfOrdersVO(String address, String phone, String nickname, String name) {
        this.address = address;
        this.phone = phone;
        this.nickname = nickname;
        this.name = name;
    }

    public UserOfOrdersVO() {
    }
}
