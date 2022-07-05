package com.ultraneos.mall.dao;

import com.ultraneos.mall.model.bo.AdminLoginBO;
import com.ultraneos.mall.model.bo.OrdersByPageBO;
import com.ultraneos.mall.model.bo.UserPwdBO;
import com.ultraneos.mall.model.po.User;
import com.ultraneos.mall.model.vo.UserVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserDao {

    List<UserVO> getAllUsers();

    List<UserVO> getUsersByNickname(@Param("n") String nickname);

    void deleteUserById(@Param("id") Integer id);

    int queryCount(@Param("bo") AdminLoginBO loginBO);

    void addUser(@Param("vo") UserVO userVO);

    User getUserByName(@Param("name") String token);

    void updateUserPwd(@Param("userPwdBO") UserPwdBO userPwdBO);

    void updataUser(UserVO userVO);
}
