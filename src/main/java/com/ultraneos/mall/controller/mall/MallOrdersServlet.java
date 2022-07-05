package com.ultraneos.mall.controller.mall;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.ultraneos.mall.model.bo.AddOrderBO;
import com.ultraneos.mall.model.bo.CartBO;
import com.ultraneos.mall.model.bo.CartListBo;
import com.ultraneos.mall.model.bo.CommentsBO;
import com.ultraneos.mall.model.vo.GetOrdersByStateVO;
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
import java.util.List;

/**
 * @author Saitama
 * @since 2022/06/30 13:41
 */
@WebServlet("/api/mall/order/*")
public class MallOrdersServlet extends HttpServlet {
    Gson gson = new Gson();
    OrdersService ordersService = new OrdersServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String requestURI = req.getRequestURI();
        String op = requestURI.replace(req.getContextPath() + "/api/mall/order/", "");
        if ("getOrderByState".equals(op)) {
            getOrderByState(req, resp);
        }else if ("deleteOrder".equals(op)) {
            deleteOrder(req, resp);
        }else if ("pay".equals(op)) {
            pay(req, resp);
        }else if ("confirmReceive".equals(op)) {
            confirmReceive(req, resp);
        }
    }

    private void confirmReceive(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String id = req.getParameter("id");
        ordersService.confirm(id);
        resp.getWriter().println(gson.toJson(new Result(0,null,null)));
    }

    private void pay(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String id = req.getParameter("id");
        int code = ordersService.pay(id);
        Result result;
        if(code!=0){
            result = new Result(code,"库存容量不足",null);
        }else {
            result = new Result(code,null,null);
        }
        resp.getWriter().println(gson.toJson(result));
    }

    private void deleteOrder(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String id = req.getParameter("id");
        int code = ordersService.deleteOrder(id);
        resp.getWriter().println(gson.toJson(new Result(code, null, null)));
    }

    private void getOrderByState(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Integer state = Integer.parseInt(req.getParameter("state"));
        String token = req.getParameter("token");
        List<GetOrdersByStateVO> getOrdersByStateVOS = ordersService.getOrdersByUsernameAndState(token,state);
        resp.getWriter().println(gson.toJson(new Result(0, null, getOrdersByStateVOS)));
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String requestURI = req.getRequestURI();
        String op = requestURI.replace(req.getContextPath() + "/api/mall/order/", "");
        if ("addOrder".equals(op)) {
            addOrder(req, resp);
        }else if ("settleAccounts".equals(op)) {
            settleAccounts(req, resp);
        }else if ("sendComment".equals(op)) {
            sendComment(req, resp);
        }
    }

    private void sendComment(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String requestBody = HttpUtils.getRequestBody(req);
        CommentsBO commentsBO = gson.fromJson(requestBody, CommentsBO.class);
        ordersService.sendComment(commentsBO);
        resp.getWriter().println(gson.toJson(new Result(0, null, null)));
    }

    private void settleAccounts(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String requestBody = HttpUtils.getRequestBody(req);
        CartListBo cartListBo = gson.fromJson(requestBody, CartListBo.class);
        List<CartBO> cartBOList = cartListBo.getCartList();
        int code = ordersService.settleAccount(cartBOList);
        Result result;
        if(code!=0){
            result = new Result(code,"库存容量不足",null);
        }else {
            result = new Result(code,null,null);
        }
        resp.getWriter().println(gson.toJson(result));
    }

    private void addOrder(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String requestBody = HttpUtils.getRequestBody(req);
        AddOrderBO addOrderBO = gson.fromJson(requestBody, AddOrderBO.class);
        int code = ordersService.addOrder(addOrderBO);
        Result result;
        if(code!=0){
            result = new Result(code,"库存容量不足",null);
        }else {
            result = new Result(code,null,null);
        }
        resp.getWriter().println(gson.toJson(result));
    }
}
