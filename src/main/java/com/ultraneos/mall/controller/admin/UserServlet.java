package com.ultraneos.mall.controller.admin;

import com.google.gson.Gson;
import com.ultraneos.mall.model.vo.UserVO;
import com.ultraneos.mall.service.UserService;
import com.ultraneos.mall.service.impl.UserServiceImpl;
import com.ultraneos.mall.util.Result;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author Saitama
 * @since 2022/06/29 19:57
 */
@WebServlet("/api/admin/user/*")
public class UserServlet extends HttpServlet {
    Gson gson = new Gson();
    UserService userService = new UserServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String requestURI = req.getRequestURI();
        String op = requestURI.replace(req.getContextPath() + "/api/admin/user/", "");
        if ("allUser".equals(op)) {
            allUser(req, resp);
        }else if ("searchUser".equals(op)) {
            searchUser(req, resp);
        }else if ("deleteUser".equals(op)) {
            deleteUser(req, resp);
        }
    }

    private void deleteUser(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Integer id = Integer.parseInt(req.getParameter("id"));
        int code = userService.deleteUser(id);
        resp.getWriter().println(gson.toJson(new Result(code, null, null)));
    }

    private void searchUser(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String nickname = req.getParameter("word");
        List<UserVO> userVOS = userService.getUsers(nickname);
        resp.getWriter().println(gson.toJson(new Result(0, null, userVOS)));
    }

    private void allUser(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        List<UserVO> allUserVOS = userService.getAllUsers();
        resp.getWriter().println(gson.toJson(new Result(0, null, allUserVOS)));
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
