package com.ultraneos.mall.controller.mall;

import com.google.gson.Gson;
import com.ultraneos.mall.model.bo.AskMsgBO;
import com.ultraneos.mall.model.vo.*;
import com.ultraneos.mall.service.GoodsService;
import com.ultraneos.mall.service.impl.GoodsServiceImpl;
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
 * @since 2022/06/30 10:00
 */
@WebServlet("/api/mall/goods/*")
public class MallGoodsServlet extends HttpServlet {
    Gson gson = new Gson();
    GoodsService goodsService = new GoodsServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String requestURI = req.getRequestURI();
        String op = requestURI.replace(req.getContextPath() + "/api/mall/goods/", "");
        if ("getGoodsByType".equals(op)) {
            getGoodsByType(req, resp);
        } else if ("searchGoods".equals(op)) {
            searchGoods(req, resp);
        }else if ("getGoodsInfo".equals(op)) {
            getGoodsInfo(req, resp);
        }else if ("getGoodsMsg".equals(op)) {
            getGoodsMsg(req, resp);
        }else if ("getGoodsComment".equals(op)) {
            getGoodsComment(req, resp);
        }
    }

    private void getGoodsComment(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Integer goodsId = Integer.parseInt(req.getParameter("goodsId"));
        List<CommentsVO> commentsVOS = goodsService.getComments(goodsId);
        if(commentsVOS.size()==0){
            resp.getWriter().println(gson.toJson(new Result(0, null,new GetCommentsVO(commentsVOS,"NaN"))));
            return;
        }
        int count =0;
        for (CommentsVO commentsVO : commentsVOS) {
            if(commentsVO.getScore()==100){
                count++;
            }
        }
        Double rate = Double.valueOf(count/commentsVOS.size()*100);
        resp.getWriter().println(gson.toJson(new Result(0, null,new GetCommentsVO(commentsVOS,rate.toString()))));
    }


    private void getGoodsMsg(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Integer id = Integer.parseInt(req.getParameter("id"));
        List<GoodsMsgVO> goodsMsgVOList = goodsService.getMsg(id);
        resp.getWriter().println(gson.toJson(new Result(0, null,goodsMsgVOList)));
    }

    private void getGoodsInfo(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Integer id = Integer.parseInt(req.getParameter("id"));
        MallGoodsInfoVO mallGoodsInfoVO= goodsService.getMallGoodsInfo(id);
        resp.getWriter().println(gson.toJson(new Result(0, null,mallGoodsInfoVO)));
    }

    private void searchGoods(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String keyword = req.getParameter("keyword");
        List<GetGoodsByTypeVO> getGoodsByName = goodsService.getGoodsByName(keyword);
        resp.getWriter().println(gson.toJson(new Result(0, null, getGoodsByName)));
    }

    private void getGoodsByType(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Integer id = Integer.parseInt(req.getParameter("typeId"));
        List<GetGoodsByTypeVO> getGoodsByTypeVOS;
        if (id != -1) {
            getGoodsByTypeVOS = goodsService.getGoodsByType(id);
        } else {
            getGoodsByTypeVOS = goodsService.getGoods();
        }
        resp.getWriter().println(gson.toJson(new Result(0, null, getGoodsByTypeVOS)));
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String requestURI = req.getRequestURI();
        String op = requestURI.replace(req.getContextPath() + "/api/mall/goods/", "");
        if ("askGoodsMsg".equals(op)) {
            askGoodsMsg(req, resp);
        }
    }

    private void askGoodsMsg(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String requestBody = HttpUtils.getRequestBody(req);
        AskMsgBO askMsgBO = gson.fromJson(requestBody, AskMsgBO.class);
        goodsService.addMsg(askMsgBO);
        resp.getWriter().println(gson.toJson(new Result(0, null, null)));
    }
}
