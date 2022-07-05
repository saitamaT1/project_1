package com.ultraneos.mall.model.bo;

/**
 * @author Saitama
 * @since 2022/06/28 22:13
 */

public class AdminpwdBO {

    /**
     * newPwd :
     * confirmPwd :
     * adminToken : admin
     * oldPwd :
     */
    private String newPwd;
    private String confirmPwd;
    private String adminToken;
    private String oldPwd;

    public AdminpwdBO(String newPwd, String confirmPwd, String adminToken, String oldPwd) {
        this.newPwd = newPwd;
        this.confirmPwd = confirmPwd;
        this.adminToken = adminToken;
        this.oldPwd = oldPwd;
    }

    public AdminpwdBO() {
    }

    public void setNewPwd(String newPwd) {
        this.newPwd = newPwd;
    }

    public void setConfirmPwd(String confirmPwd) {
        this.confirmPwd = confirmPwd;
    }

    public void setAdminToken(String adminToken) {
        this.adminToken = adminToken;
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

    public String getAdminToken() {
        return adminToken;
    }

    public String getOldPwd() {
        return oldPwd;
    }
}
