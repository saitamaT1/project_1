package com.ultraneos.mall.controller.admin;

import com.google.gson.Gson;
import com.ultraneos.mall.model.bo.AdminAddBO;
import com.ultraneos.mall.model.bo.AdminLoginBO;
import com.ultraneos.mall.model.bo.AdminSearchBO;
import com.ultraneos.mall.model.bo.AdminpwdBO;
import com.ultraneos.mall.model.vo.AdminInfoVO;
import com.ultraneos.mall.model.vo.AdminLoginVO;
import com.ultraneos.mall.service.AdminService;
import com.ultraneos.mall.service.impl.AdminServiceImpl;
import com.ultraneos.mall.util.HttpUtils;
import com.ultraneos.mall.util.Result;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * @author Saitama
 * @since 2022/06/28 10:16
 */
@WebServlet("/api/admin/admin/*")
public class AdminServlet extends HttpServlet {

    Gson gson = new Gson();
    AdminService adminService = new AdminServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String requestURI = req.getRequestURI();
        String op = requestURI.replace(req.getContextPath() + "/api/admin/admin/", "");
        if ("allAdmins".equals(op)) {
            allAdmins(req, resp);
        } else if ("deleteAdmins".equals(op)) {
            deleteAdmins(req, resp);
        } else if ("getAdminsInfo".equals(op)) {
            getAdminsInfo(req, resp);
        }
    }

    private void getAdminsInfo(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String loginAdmin = (String) req.getSession().getAttribute("loginAdmin");
        if(!"admin".equals(loginAdmin)){
            resp.getWriter().println(gson.toJson(new Result(10000, "无权限", null)));
            return;
        }
        Integer id = Integer.parseInt(req.getParameter("id"));
        if (id == null) {
            resp.getWriter().println(gson.toJson(new Result(10000, "id不能为空", null)));
            return;
        }
        if (id == 5) {
            resp.getWriter().println(gson.toJson(new Result(10000, "无权限修改admin", null)));
            return;
        }
        AdminInfoVO adminInfoVO = adminService.getAdmin(id);
        resp.getWriter().println(gson.toJson(new Result(0, null, adminInfoVO)));
    }

    private void deleteAdmins(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String loginAdmin = (String) req.getSession().getAttribute("loginAdmin");
        if(!"admin".equals(loginAdmin)){
            resp.getWriter().println(gson.toJson(new Result(10000, "无权限", null)));
            return;
        }
        Integer id = Integer.parseInt(req.getParameter("id"));
        if (id == null) {
            resp.getWriter().println(gson.toJson(new Result(10000, "id不能为空", null)));
            return;
        }
        if (id == 5) {
            resp.getWriter().println(gson.toJson(new Result(10000, "无权限删除admin", null)));
            return;
        }
        int code = adminService.deleteAdmin(id);
        Result result;
        if (code == 0) {
            result = new Result(code, null, null);
        } else {
            result = new Result(code, "id不存在", null);
        }
        resp.getWriter().println(gson.toJson(result));
    }

    //显示所有现有管理员
    private void allAdmins(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String loginAdmin = (String) req.getSession().getAttribute("loginAdmin");
        List<AdminInfoVO> adminInfoVOS = adminService.allAdmins();
        if(!"admin".equals(loginAdmin)){
            for (int i = 0; i < adminInfoVOS.size(); i++) {
                adminInfoVOS.get(i).setPwd("******");
            }
            resp.getWriter().println(gson.toJson(new Result(0, null, adminInfoVOS)));
            return;
        }
        resp.getWriter().println(gson.toJson(new Result(0, null, adminInfoVOS)));
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String requestURI = req.getRequestURI();
        String op = requestURI.replace(req.getContextPath() + "/api/admin/admin/", "");
        if ("login".equals(op)) {
            login(req, resp);
        } else if ("addAdminss".equals(op)) {
            addAdminss(req, resp);
        } else if ("getSearchAdmins".equals(op)) {
            getSearchAdmins(req, resp);
        } else if ("updateAdminss".equals(op)) {
            updateAdminss(req, resp);
        } else if ("changePwd".equals(op)) {
            changePwd(req, resp);
        }else if ("logoutAdmin".equals(op)) {
            logoutAdmin(req, resp);
        }
    }

    private void logoutAdmin(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        HttpSession session = req.getSession();
        session.invalidate();
        resp.getWriter().println(gson.toJson(new Result(0,null,null)));
    }

    private void changePwd(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String requestBody = HttpUtils.getRequestBody(req);
        AdminpwdBO adminpwdBO = gson.fromJson(requestBody, AdminpwdBO.class);
        if (!adminpwdBO.getAdminToken().equals(req.getSession().getAttribute("loginAdmin"))) {
            resp.getWriter().println(gson.toJson(new Result(10000, "token验证错误", null)));
            return;
        }
        String oldPwd = adminService.getPwdOfAdmin(adminpwdBO);
        if (!adminpwdBO.getOldPwd().equals(oldPwd)) {
            resp.getWriter().println(gson.toJson(new Result(10000, "旧密码错误", null)));
            return;
        }
        if (!adminpwdBO.getNewPwd().equals(adminpwdBO.getConfirmPwd())) {
            resp.getWriter().println(gson.toJson(new Result(10000, "请保证两次密码输入一致", null)));
            return;
        }
        Result result;
        int code = adminService.updatePwdOfAdmin(adminpwdBO);
        if (code == 0) {
            result = new Result(code, null, null);
        } else {
            result = new Result(code, "未找到", null);
        }
        resp.getWriter().println(gson.toJson(result));
    }

    private void updateAdminss(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String loginAdmin = (String) req.getSession().getAttribute("loginAdmin");
        if(!"admin".equals(loginAdmin)){
            resp.getWriter().println(gson.toJson(new Result(10000, "无权限修改", null)));
            return;
        }
        String requestBody = HttpUtils.getRequestBody(req);
        AdminInfoVO adminInfoVO = gson.fromJson(requestBody, AdminInfoVO.class);
        int code = adminService.updateAdmin(adminInfoVO);
        Result result;
        if (code == 0) {
            result = new Result(code, null, null);
        } else {
            result = new Result(code, "未找到", null);
        }
        resp.getWriter().println(gson.toJson(result));
    }

    //按昵称或账号搜索现有管理员
    private void getSearchAdmins(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String requestBody = HttpUtils.getRequestBody(req);
        AdminSearchBO adminSearchBO = gson.fromJson(requestBody, AdminSearchBO.class);
        //过滤空字符
        if (adminSearchBO.getEmail().length() == 0) {
            adminSearchBO.setEmail(null);
        }
        if (adminSearchBO.getNickname().length() == 0) {
            adminSearchBO.setNickname(null);
        }
        List<AdminInfoVO> adminInfoVOS = adminService.searchAdmins(adminSearchBO);
        resp.getWriter().println(gson.toJson(new Result(0, null, adminInfoVOS)));
    }

    //添加管理员
    private void addAdminss(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String requestBody = HttpUtils.getRequestBody(req);
        AdminAddBO adminAddBO = gson.fromJson(requestBody, AdminAddBO.class);
        Result result = null;
        //校验
        //空
        if (StringUtils.isEmpty(adminAddBO.getNickname())
                || StringUtils.isEmpty(adminAddBO.getEmail())
                || StringUtils.isEmpty(adminAddBO.getPwd())) {
            result = new Result(10000, "昵称，用户名，密码不能为空", null);
            resp.getWriter().println(gson.toJson(result));
            return;
        }
        //重复
        int code = adminService.addAdmin(adminAddBO);
        if (code == 0) {
            //添加成功
            result = new Result(0, null, null);
        } else if (code == 10000) {
            //用户名重复，添加失败
            result = new Result(10000, "账号不能重复", null);
        } else if (code == 5000) {
            //账号 昵称 密码 格式不对 TODO

        }
        resp.getWriter().println(gson.toJson(result));
    }


    //管理员登陆
    private void login(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        HttpSession session = req.getSession();
        String requestBody = HttpUtils.getRequestBody(req);
        AdminLoginBO loginBO = gson.fromJson(requestBody, AdminLoginBO.class);
        //校验
        Result result = null;
        //空
        if (StringUtils.isEmpty(loginBO.getEmail()) || StringUtils.isEmpty(loginBO.getPwd())) {
            //输出  TODO 空
            result = new Result(10000, "用户名，密码不能为空", null);
            resp.getWriter().println(gson.toJson(result));
            return;
        }

        int code = adminService.login(loginBO);

        if (code == 200) {
            //登陆成功
            result = new Result(0, null, new AdminLoginVO(loginBO.getEmail(), loginBO.getEmail()));
            session.setAttribute("loginAdmin", loginBO.getEmail());
            System.out.println(session.getAttribute("loginAdmin"));
        } else if (code == 404) {
            //登录失败 用户名，密码错误
            result = new Result(10000, "用户名，密码错误", null);
        }
        resp.getWriter().println(gson.toJson(result));
    }

}
