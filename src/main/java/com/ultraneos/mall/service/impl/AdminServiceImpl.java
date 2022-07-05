package com.ultraneos.mall.service.impl;

import com.ultraneos.mall.dao.AdminDao;
import com.ultraneos.mall.model.bo.AdminAddBO;
import com.ultraneos.mall.model.bo.AdminLoginBO;
import com.ultraneos.mall.model.bo.AdminSearchBO;
import com.ultraneos.mall.model.bo.AdminpwdBO;
import com.ultraneos.mall.model.po.Admin;
import com.ultraneos.mall.model.vo.AdminInfoVO;
import com.ultraneos.mall.service.AdminService;
import com.ultraneos.mall.util.MybatisUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

/**
 * @author Saitama
 * @since 2022/06/28 10:18
 */

public class AdminServiceImpl implements AdminService {


    @Override
    public int login(AdminLoginBO loginBO) {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        AdminDao adminDao = sqlSession.getMapper(AdminDao.class);
        Admin admin = new Admin(null,loginBO.getEmail(),loginBO.getPwd(),null);
        int count = adminDao.queryCount(admin);
        sqlSession.commit();
        sqlSession.close();
        if(count==0){
            return 404;
        }
        return 200;
    }

    @Override
    public List<AdminInfoVO> allAdmins() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        AdminDao adminDao = sqlSession.getMapper(AdminDao.class);
        List<AdminInfoVO> adminInfoVOS= adminDao.queryAll();
        sqlSession.commit();
        sqlSession.close();
        return adminInfoVOS;
    }

    @Override
    public int addAdmin(AdminAddBO adminAddBO) {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        AdminDao adminDao = sqlSession.getMapper(AdminDao.class);
        Admin admin = new Admin(null, adminAddBO.getEmail(), adminAddBO.getPwd(), adminAddBO.getNickname());
        int count = adminDao.queryCountUsername(admin);
        if(count==1){
            sqlSession.commit();
            sqlSession.close();
            return 10000;
        }
        int code = adminDao.addAdmin(admin);
        sqlSession.commit();
        sqlSession.close();
        if(code==0){
            return 10000;
        }
        return 0;
    }

    @Override
    public List<AdminInfoVO> searchAdmins(AdminSearchBO adminSearchBO) {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        AdminDao adminDao = sqlSession.getMapper(AdminDao.class);
        List<AdminInfoVO> adminInfoVOS= adminDao.queryByUsernameAndNickname(adminSearchBO);
        sqlSession.commit();
        sqlSession.close();
        return adminInfoVOS;
    }

    @Override
    public int deleteAdmin(Integer id) {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        AdminDao adminDao = sqlSession.getMapper(AdminDao.class);
        int count = adminDao.deleteAdminById(id);
        sqlSession.commit();
        sqlSession.close();
        if(count!=1){
            return 10000;
        }
        return 0;
    }

    @Override
    public AdminInfoVO getAdmin(Integer id) {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        AdminDao adminDao = sqlSession.getMapper(AdminDao.class);
        AdminInfoVO admin = adminDao.getAdminById(id);
        sqlSession.commit();
        sqlSession.close();
        return admin;
    }

    @Override
    public int updateAdmin(AdminInfoVO adminInfoVO) {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        AdminDao adminDao = sqlSession.getMapper(AdminDao.class);
        int count = adminDao.updateAdmin(adminInfoVO);
        sqlSession.commit();
        sqlSession.close();
        if(count!=1){
            return 10000;
        }
        return 0;
    }

    @Override
    public int updatePwdOfAdmin(AdminpwdBO adminpwdBO) {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        AdminDao adminDao = sqlSession.getMapper(AdminDao.class);
        int count = adminDao.updatePwdOfAdmin(adminpwdBO);
        sqlSession.commit();
        sqlSession.close();
        if(count!=1){
            return 10000;
        }
        return 0;
    }

    @Override
    public String getPwdOfAdmin(AdminpwdBO adminpwdBO) {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        AdminDao adminDao = sqlSession.getMapper(AdminDao.class);
        String Pwd = adminDao.queryPwdOfAdmin(adminpwdBO);
        sqlSession.commit();
        sqlSession.close();
        return Pwd;
    }

}
