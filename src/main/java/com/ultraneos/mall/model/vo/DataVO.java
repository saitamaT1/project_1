package com.ultraneos.mall.model.vo;

/**
 * @author Saitama
 * @since 2022/07/01 19:25
 */

public class DataVO {

    /**
     * code : 0
     * address : 阿萨大大是
     * phone : 1333333333
     * nickname : asad
     * recipient : 实打实
     * id : 103
     * email : 231231@qq.com
     */
    private int code;
    private String address;
    private String phone;
    private String nickname;
    private String recipient;
    private Integer id;
    private String email;

    public DataVO(int code, String address, String phone, String nickname, String recipient, Integer id, String email) {
        this.code = code;
        this.address = address;
        this.phone = phone;
        this.nickname = nickname;
        this.recipient = recipient;
        this.id = id;
        this.email = email;
    }

    public DataVO() {
    }

    public void setCode(int code) {
        this.code = code;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getCode() {
        return code;
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

    public String getRecipient() {
        return recipient;
    }

    public Integer getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }
}
