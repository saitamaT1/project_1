package com.ultraneos.mall.model.bo;

/**
 * @author Saitama
 * @since 2022/07/01 19:45
 */

public class UserPwdBO {

    /**
     * newPwd :
     * confirmPwd :
     * id : 3
     * oldPwd :
     */
    private String newPwd;
    private String confirmPwd;
    private int id;
    private String oldPwd;

    public void setNewPwd(String newPwd) {
        this.newPwd = newPwd;
    }

    public void setConfirmPwd(String confirmPwd) {
        this.confirmPwd = confirmPwd;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setOldPwd(String oldPwd) {
        this.oldPwd = oldPwd;
    }

    public String getNewPwd() {
        return newPwd;
    }

    public String getConfirmPwd() {
        return confirmPwd;
    }

    public int getId() {
        return id;
    }

    public String getOldPwd() {
        return oldPwd;
    }
}
