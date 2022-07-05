package com.ultraneos.mall.controller.admin;

import com.google.gson.Gson;
import com.ultraneos.mall.model.bo.ChangeOrdersBO;
import com.ultraneos.mall.model.bo.OrdersByPageBO;
import com.ultraneos.mall.model.vo.OrderByPageVO;

import com.ultraneos.mall.model.vo.OrdersVO;
import com.ultraneos.mall.service.OrdersService;
import com.ultraneos.mall.service.impl.OrdersServiceImpl;
import com.ultraneos.mall.util.HttpUtils;
import com.ultraneos.mall.util.Result;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
/**
 * @author Saitama
 * @since 2022/06/28 10:27
 */
@WebServlet("/api/admin/order/*")
public class OrdersServlet extends HttpServlet {
    Gson gson = new Gson();
    OrdersService ordersService = new OrdersServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String requestURI = req.getRequestURI();
        String op = requestURI.replace(req.getContextPath() + "/api/admin/order/", "");
        if ("deleteOrder".equals(op)) {
            deleteOrder(req, resp);
        }else if ("order".equals(op)) {
            order(req, resp);
        }
    }

    private void order(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String id = req.getParameter("id");
        OrdersVO ordersVO = ordersService.getOrders(id);
        resp.getWriter().println(gson.toJson(new Result(0, null, ordersVO)));
    }

    private void deleteOrder(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String id = req.getParameter("id");
        int code = ordersService.deleteOrder(id);
        resp.getWriter().println(gson.toJson(new Result(code, null, null)));
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String requestURI = req.getRequestURI();
        String op = requestURI.replace(req.getContextPath() + "/api/admin/order/", "");
        if ("ordersByPage".equals(op)) {
            ordersByPage(req, resp);
        }else if ("changeOrder".equals(op)) {
            changeOrder(req, resp);
        }
    }

    private void changeOrder(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String requestBody = HttpUtils.getRequestBody(req);
        ChangeOrdersBO changeOrdersBO = gson.fromJson(requestBody, ChangeOrdersBO.class);
        if(changeOrdersBO.getNum()==0){
            return;
        }
        int code = ordersService.changeOrder(changeOrdersBO);
        resp.getWriter().println(gson.toJson(new Result(code, null, null)));
    }

    //TODO 未筛选
    private void ordersByPage(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String requestBody = HttpUtils.getRequestBody(req);
        OrdersByPageBO ordersByPageBO = gson.fromJson(requestBody, OrdersByPageBO.class);
        OrderByPageVO orderByPageVO = ordersService.getordersByPage(ordersByPageBO);
        resp.getWriter().println(gson.toJson(
                new Result(0, null, orderByPageVO)));
    }
}
