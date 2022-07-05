package com.ultraneos.mall.controller.admin;

import com.google.gson.Gson;
import com.ultraneos.mall.model.bo.*;
import com.ultraneos.mall.model.po.Type;
import com.ultraneos.mall.model.vo.GetGoodsByTypeVO;
import com.ultraneos.mall.model.vo.GoodsInfoVO;
import com.ultraneos.mall.model.vo.MsgVO;
import com.ultraneos.mall.service.GoodsService;
import com.ultraneos.mall.service.impl.GoodsServiceImpl;
import com.ultraneos.mall.util.Constant;
import com.ultraneos.mall.util.FileUploadUtils;
import com.ultraneos.mall.util.HttpUtils;
import com.ultraneos.mall.util.Result;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author Saitama
 * @since 2022/06/28 10:26
 */
@WebServlet("/api/admin/goods/*")
public class GoodsServlet extends HttpServlet {

    Gson gson = new Gson();
    GoodsService goodsService = new GoodsServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String requestURI = req.getRequestURI();
        String op = requestURI.replace(req.getContextPath() + "/api/admin/goods/", "");
        if ("getType".equals(op)) {
            getType(req, resp);
        } else if ("getGoodsByType".equals(op)) {
            getGoodsByType(req, resp);
        }else if ("deleteType".equals(op)) {
            deleteType(req, resp);
        }else if ("getGoodsInfo".equals(op)) {
            getGoodsInfo(req, resp);
        }else if ("deleteGoods".equals(op)) {
            deleteGoods(req, resp);
        }else if ("noReplyMsg".equals(op)) {
            noReplyMsg(req, resp);
        }else if ("repliedMsg".equals(op)) {
            repliedMsg(req, resp);
        }
    }

    private void repliedMsg(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        List<MsgVO> msgVOS = goodsService.getReplyMsg(Constant.REPLY_CODE);
        resp.getWriter().println(gson.toJson(new Result(0, null, msgVOS)));
    }

    private void noReplyMsg(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        List<MsgVO> msgVOS = goodsService.getNoReplyMsg(Constant.NO_REPLY_CODE);
        resp.getWriter().println(gson.toJson(new Result(0, null, msgVOS)));
    }

    private void deleteGoods(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Integer id = Integer.parseInt(req.getParameter("id"));
        int code = goodsService.deleteGoods(id);
        resp.getWriter().println(gson.toJson(new Result(code, null, null)));
    }

    private void getGoodsInfo(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Integer id = Integer.parseInt(req.getParameter("id"));
        GoodsInfoVO goodsInfoVO = goodsService.getGoodsInfo(id);
        resp.getWriter().println(gson.toJson(new Result(0, null,goodsInfoVO)));
    }

    private void deleteType(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Integer id = Integer.parseInt(req.getParameter("typeId"));
        int code = goodsService.deleteTypeById(id);
        resp.getWriter().println(gson.toJson(new Result(code, null, null)));
    }

    private void getGoodsByType(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Integer id = Integer.parseInt(req.getParameter("typeId"));
        List<GetGoodsByTypeVO> getGoodsByTypeVOS = goodsService.getGoodsByType(id);
        resp.getWriter().println(gson.toJson(new Result(0, null, getGoodsByTypeVOS)));
    }

    private void getType(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        List<Type> typeList = goodsService.getType();
        resp.getWriter().println(gson.toJson(new Result(0, null, typeList)));
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String requestURI = req.getRequestURI();
        String op = requestURI.replace(req.getContextPath() + "/api/admin/goods/", "");
        if ("addGoods".equals(op)) {
            addGoods(req, resp);
        } else if ("addType".equals(op)) {
            addType(req, resp);
        } else if ("imgUpload".equals(op)) {
            imgUpload(req, resp);
        }else if ("addSpec".equals(op)) {
            addSpec(req, resp);
        }else if ("deleteSpec".equals(op)) {
            deleteSpec(req, resp);
        }else if ("updateGoods".equals(op)) {
            updateGoods(req, resp);
        }else if ("reply".equals(op)) {
            reply(req, resp);
        }
    }

    private void reply(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String requestBody = HttpUtils.getRequestBody(req);
        MsgReplyBO msgReplyBO = gson.fromJson(requestBody, MsgReplyBO.class);
        int code = goodsService.updateMsg(msgReplyBO);
        Result result;
        if (code != 0) {
            result = new Result(code, "回复不能为空", null);
        } else {
            result = new Result(code, null, null);
        }
        resp.getWriter().println(gson.toJson(result));
    }

    private void updateGoods(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String requestBody = HttpUtils.getRequestBody(req);
        UpdateGoodsBO updateGoodsBO =null;
        Result result;
        try {
            updateGoodsBO = gson.fromJson(requestBody, UpdateGoodsBO.class);
        } catch (Exception e) {
            result = new Result(10000, "参数格式错误", null);
            resp.getWriter().println(gson.toJson(result));
            return;
        }
        int code = goodsService.updateGoods(updateGoodsBO);
        if (code != 0) {
            if (code == 10000) {
                result = new Result(code, "商品名称，图片，规格不能为空", null);
            } else {
                result = new Result(10000, "商品名称重复", null);
            }
        } else {
            result = new Result(code, null, null);
        }
        resp.getWriter().println(gson.toJson(result));
    }

    private void deleteSpec(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String requestBody = HttpUtils.getRequestBody(req);
        AddSpecBO addSpecBO=gson.fromJson(requestBody, AddSpecBO.class);
        int code = goodsService.deleteSpec(addSpecBO);
        resp.getWriter().println(gson.toJson(new Result(code, null, null)));
    }

    private void addSpec(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String requestBody = HttpUtils.getRequestBody(req);
        Result result;
        AddSpecBO addSpecBO=null;
        try {
            addSpecBO = gson.fromJson(requestBody, AddSpecBO.class);
        }catch (Exception e){
            result = new Result(10000, "输入格式错误", null);
            resp.getWriter().println(gson.toJson(result));
            return;
        }
        if(addSpecBO.getSpecName().equals("")
                ||addSpecBO.getStockNum()==null
                ||addSpecBO.getUnitPrice()==0){
            result = new Result(10000, "不能为空", null);
            resp.getWriter().println(gson.toJson(result));
            return;
        }
        int code = goodsService.addSpecById(addSpecBO);
        if (code != 0) {
            result = new Result(code, "规格名重复", null);
        } else {
            result = new Result(code, null, addSpecBO);
        }
        resp.getWriter().println(gson.toJson(result));
    }

    private void imgUpload(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Map<String, String> fileMap = FileUploadUtils.parseReqeuest(req);
        String path = fileMap.get("file");
        resp.getWriter().println(gson.toJson(new Result(0,null,path)));
    }

    private void addType(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String requestBody = HttpUtils.getRequestBody(req);
        Type type = gson.fromJson(requestBody, Type.class);
        Result result;
        if ("".equals(type.getName())) {
            result = new Result(10000, "类目名不能为空", null);
            resp.getWriter().println(gson.toJson(result));
            return;
        }
        int code = goodsService.addType(type);
        if (code != 0) {
            result = new Result(code, "类目重复或过长", null);
        } else {
            result = new Result(code, null, null);
        }
        resp.getWriter().println(gson.toJson(result));
    }

    private void addGoods(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String requestBody = HttpUtils.getRequestBody(req);
        Result result;
        AddGoodsBO addGoodsBO = null;
        try {
            addGoodsBO = gson.fromJson(requestBody, AddGoodsBO.class);
        } catch (Exception e) {
            result = new Result(10000, "参数格式错误", null);
            resp.getWriter().println(gson.toJson(result));
            return;
        }
        List<AddGoodsSpecBO> specList = addGoodsBO.getSpecList();
        List<String> collect = specList.stream().map(AddGoodsSpecBO::getSpecName).distinct().collect(Collectors.toList());
        if(collect.size()!=specList.size()){
            result = new Result(10000, "规格名重复", null);
            resp.getWriter().println(gson.toJson(result));
            return;
        }
        int code = goodsService.addGoods(addGoodsBO);

        if (code != 0) {
            if (code == 10000) {
                result = new Result(code, "商品名称，图片，规格不能为空", null);
            } else {
                result = new Result(10000, "商品名称重复", null);
            }
        } else {
            result = new Result(code, null, null);
        }
        resp.getWriter().println(gson.toJson(result));
    }

}
