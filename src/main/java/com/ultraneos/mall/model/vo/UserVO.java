package com.ultraneos.mall.model.vo;

/**
 * @author Saitama
 * @since 2022/06/29 20:25
 */

public class UserVO {

    /**
     * address : admin
     * phone : 11111111111
     * nickname : admin
     * recipient : admin
     * id : 1
     * pwd : admin
     * email : admin
     */
    private String address;
    private String phone;
    private String nickname;
    private String recipient;
    private Integer id;
    private String pwd;
    private String email;

    public UserVO(String nickname) {
        this.nickname = nickname;
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

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public String getPwd() {
        return pwd;
    }

    public String getEmail() {
        return email;
    }
}
