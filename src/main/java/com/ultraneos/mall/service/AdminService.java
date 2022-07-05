package com.ultraneos.mall.service;

import com.ultraneos.mall.model.bo.AdminAddBO;
import com.ultraneos.mall.model.bo.AdminLoginBO;
import com.ultraneos.mall.model.bo.AdminSearchBO;
import com.ultraneos.mall.model.bo.AdminpwdBO;
import com.ultraneos.mall.model.vo.AdminInfoVO;

import java.util.List;

public interface AdminService {

    /**
     *
     * @param loginBO
     * @return  200 代表 正常登录；404 表示登陆失败
     */
    int login(AdminLoginBO loginBO);

    List<AdminInfoVO> allAdmins();

    /**
     *
     * @param adminAddBO
     * @return 0 代表 正常添加；10000 添加失败，账号重复。
     */
    int addAdmin(AdminAddBO adminAddBO);

    List<AdminInfoVO> searchAdmins(AdminSearchBO adminSearchBO);

    int deleteAdmin(Integer id);

    AdminInfoVO getAdmin(Integer id);

    int updateAdmin(AdminInfoVO adminInfoVO);

    int updatePwdOfAdmin(AdminpwdBO adminpwdBO);

    String getPwdOfAdmin(AdminpwdBO adminpwdBO);
}
