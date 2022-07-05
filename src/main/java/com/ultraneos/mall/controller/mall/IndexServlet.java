package com.ultraneos.mall.controller.mall;

import com.google.gson.Gson;
import com.ultraneos.mall.model.po.Type;
import com.ultraneos.mall.service.GoodsService;
import com.ultraneos.mall.service.impl.GoodsServiceImpl;
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
 * @since 2022/06/30 09:48
 */
@WebServlet("/api/mall/index/*")
public class IndexServlet extends HttpServlet {

    Gson gson = new Gson();
    GoodsService goodsService = new GoodsServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String requestURI = req.getRequestURI();
        String op = requestURI.replace(req.getContextPath() + "/api/mall/index/", "");
        if ("getType".equals(op)) {
            getType(req, resp);
        }
    }

    private void getType(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        List<Type> typeList = goodsService.getType();
        resp.getWriter().println(gson.toJson(new Result(0, null, typeList)));
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
