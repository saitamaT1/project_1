package com.ultraneos.mall.dao;

import com.ultraneos.mall.model.bo.AdminSearchBO;
import com.ultraneos.mall.model.bo.AdminpwdBO;
import com.ultraneos.mall.model.po.Admin;
import com.ultraneos.mall.model.vo.AdminInfoVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AdminDao {
    int queryCount(Admin admin);

    List<AdminInfoVO> queryAll();

    int addAdmin(Admin admin);

    int queryCountUsername(Admin admin);

    List<AdminInfoVO> queryByUsernameAndNickname(@Param("bo") AdminSearchBO adminSearchBO);

    int deleteAdminById(@Param("id") Integer id);

    AdminInfoVO getAdminById(@Param("id")Integer id);

    int updateAdmin(@Param("vo") AdminInfoVO adminInfoVO);

    int updatePwdOfAdmin(@Param("bo") AdminpwdBO adminpwdBO);

    String queryPwdOfAdmin(@Param("bo") AdminpwdBO adminpwdBO);
}
