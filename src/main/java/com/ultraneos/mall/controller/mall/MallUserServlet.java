package com.ultraneos.mall.controller.mall;

import com.google.gson.Gson;
import com.ultraneos.mall.model.bo.AdminLoginBO;
import com.ultraneos.mall.model.bo.UserPwdBO;
import com.ultraneos.mall.model.vo.DataVO;
import com.ultraneos.mall.model.vo.UserLoginVO;
import com.ultraneos.mall.model.vo.UserVO;
import com.ultraneos.mall.service.UserService;
import com.ultraneos.mall.service.impl.UserServiceImpl;
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
 * @since 2022/06/30 10:23
 */
@WebServlet("/api/mall/user/*")
public class MallUserServlet extends HttpServlet {
    Gson gson = new Gson();
    UserService userService = new UserServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String requestURI = req.getRequestURI();
        String op = requestURI.replace(req.getContextPath() + "/api/mall/user/", "");
        if ("data".equals(op)) {
            data(req, resp);
        }
    }

    private void data(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String username = req.getParameter("token");
        DataVO dataVO = userService.getUserDataByUsername(username);
        resp.getWriter().println(gson.toJson(new Result(0, null, dataVO)));
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String requestURI = req.getRequestURI();
        String op = requestURI.replace(req.getContextPath() + "/api/mall/user/", "");
        if ("login".equals(op)) {
            login(req, resp);
        }else if ("signup".equals(op)) {
            signup(req, resp);
        }else if ("logoutClient".equals(op)) {
            logoutClient(req, resp);
        }else if ("updatePwd".equals(op)) {
            updatePwd(req, resp);
        }else if ("updateUserData".equals(op)) {
            updateUserData(req, resp);
        }
    }

    private void updateUserData(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String requestBody = HttpUtils.getRequestBody(req);
        UserVO userVO = gson.fromJson(requestBody, UserVO.class);
        if("".equals(userVO.getNickname())||"".equals(userVO.getAddress())
                ||"".equals(userVO.getPhone())||"".equals(userVO.getRecipient())){
            resp.getWriter().println(gson.toJson(new Result(10000, "????????????????????????", null)));
            return;
        }
        userService.updateUser(userVO);
        resp.getWriter().println(gson.toJson(new Result(0, null, null)));
    }

    private void updatePwd(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String requestBody = HttpUtils.getRequestBody(req);
        UserPwdBO userPwdBO = gson.fromJson(requestBody, UserPwdBO.class);
        if("".equals(userPwdBO.getNewPwd())){
            resp.getWriter().println(gson.toJson(new Result(10000, "??????????????????", null)));
            return;
        }
        userService.updateUserPwd(userPwdBO);
        resp.getWriter().println(gson.toJson(new Result(0, null, null)));
    }

    private void logoutClient(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        HttpSession session = req.getSession();
        session.invalidate();
        resp.getWriter().println(gson.toJson(new Result(0, null, null)));
    }

    private void signup(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        HttpSession session = req.getSession();
        String requestBody = HttpUtils.getRequestBody(req);
        UserVO userVO = null;
        try {
            userVO = gson.fromJson(requestBody, UserVO.class);
        }catch (Exception e){
            resp.getWriter().println(gson.toJson(new Result(10000, "??????????????????", null)));
            return;
        }
        Result result = null;
        int code = userService.register(userVO);
        if (code == 0) {
            //????????????
            result = new Result(0, null, new UserLoginVO(0,userVO.getEmail(),userVO.getEmail()));
            session.setAttribute("loginUser", userVO.getEmail());
        } else if (code == 10000) {
            //??????????????????????????????
            result = new Result(10000, "??????????????????", null);
        } else if (code == 5000) {
            //?????? ?????? ?????? ???????????? TODO
        }
        resp.getWriter().println(gson.toJson(result));
    }


    private void login(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        HttpSession session = req.getSession();
        String requestBody = HttpUtils.getRequestBody(req);
        AdminLoginBO loginBO = gson.fromJson(requestBody, AdminLoginBO.class);
        //??????
        Result result = null;
        //???
        if (StringUtils.isEmpty(loginBO.getEmail()) || StringUtils.isEmpty(loginBO.getPwd())) {
            //??????  TODO ???
            result = new Result(10000, "??????????????????????????????", null);
            resp.getWriter().println(gson.toJson(result));
            return;
        }
        int code = userService.login(loginBO);
        if (code == 200) {
            //????????????
            result = new Result(0, null, new UserLoginVO(0,loginBO.getEmail(), loginBO.getEmail()));
            session.setAttribute("loginUser", loginBO.getEmail());
        } else if (code == 404) {
            //???????????? ????????????????????????
            result = new Result(10000, "????????????????????????", null);
        }
        resp.getWriter().println(gson.toJson(result));
    }
}
