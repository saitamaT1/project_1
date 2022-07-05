package com.ultraneos.mall.service.impl;

import com.ultraneos.mall.dao.UserDao;
import com.ultraneos.mall.model.bo.AdminLoginBO;
import com.ultraneos.mall.model.bo.UserPwdBO;
import com.ultraneos.mall.model.po.User;
import com.ultraneos.mall.model.vo.DataVO;
import com.ultraneos.mall.model.vo.UserVO;
import com.ultraneos.mall.service.UserService;
import com.ultraneos.mall.util.Constant;
import com.ultraneos.mall.util.MybatisUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

/**
 * @author Saitama
 * @since 2022/06/29 20:03
 */

public class UserServiceImpl implements UserService {

    @Override
    public List<UserVO> getAllUsers() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        List<UserVO> userVOS = userDao.getAllUsers();
        sqlSession.commit();
        sqlSession.close();
        return userVOS;
    }

    @Override
    public List<UserVO> getUsers(String nickname) {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        List<UserVO> userVOList = userDao.getUsersByNickname(nickname);
        sqlSession.commit();
        sqlSession.close();
        return userVOList;
    }

    @Override
    public int deleteUser(Integer id) {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        userDao.deleteUserById(id);
        sqlSession.commit();
        sqlSession.close();
        return 0;
    }

    @Override
    public int login(AdminLoginBO loginBO) {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        int count = userDao.queryCount(loginBO);
        sqlSession.commit();
        sqlSession.close();
        if(count==0){
            return Constant.NOT_FOUND_CODE;
        }
        return Constant.SUCCESS_CODE;
    }

    @Override
    public int register(UserVO userVO) {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        try {
            userDao.addUser(userVO);
        }catch (Exception e){
            sqlSession.commit();
            sqlSession.close();
            return 10000;
        }
        sqlSession.commit();
        sqlSession.close();
        return 0;
    }

    @Override
    public DataVO getUserDataByUsername(String username) {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        User user = userDao.getUserByName(username);
        DataVO dataVO = new DataVO(0,user.getAddress(),user.getPhoneNum(),user.getNickname(),user.getRecName(),user.getId(),user.getName());
        sqlSession.commit();
        sqlSession.close();
        return dataVO;
    }

    @Override
    public void updateUserPwd(UserPwdBO userPwdBO) {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        userDao.updateUserPwd(userPwdBO);
        sqlSession.commit();
        sqlSession.close();
    }

    @Override
    public void updateUser(UserVO userVO) {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        userDao.updataUser(userVO);
        sqlSession.commit();
        sqlSession.close();
    }
}
