package com.ultraneos.test;

import com.ultraneos.mall.model.bo.AdminLoginBO;
import com.ultraneos.mall.service.AdminService;
import com.ultraneos.mall.service.impl.AdminServiceImpl;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Saitama
 * @since 2022/06/28 13:42
 */

public class AdminServiceTest {

    @Test
    public void testLogin(){
        AdminService adminService = new AdminServiceImpl();
        AdminLoginBO adminLoginBO = new AdminLoginBO();
        adminLoginBO.setEmail("admin");
        adminLoginBO.setPwd("admin");
        int code = adminService.login(adminLoginBO);
        Assert.assertEquals(200,code);
    }
}
