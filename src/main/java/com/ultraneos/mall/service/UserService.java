package com.ultraneos.mall.service;

import com.ultraneos.mall.model.bo.AdminLoginBO;
import com.ultraneos.mall.model.bo.UserPwdBO;
import com.ultraneos.mall.model.vo.DataVO;
import com.ultraneos.mall.model.vo.UserVO;

import java.util.List;

public interface UserService {

    List<UserVO> getAllUsers();

    List<UserVO> getUsers(String nickname);

    int deleteUser(Integer id);

    int login(AdminLoginBO loginBO);

    int register(UserVO userVO);

    DataVO getUserDataByUsername(String username);

    void updateUserPwd(UserPwdBO userPwdBO);

    void updateUser(UserVO userVO);
}
