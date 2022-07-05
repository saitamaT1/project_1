package com.ultraneos.mall.service.impl;

import com.ultraneos.mall.dao.GoodsDao;
import com.ultraneos.mall.dao.OrdersDao;
import com.ultraneos.mall.model.bo.*;
import com.ultraneos.mall.model.po.*;
import com.ultraneos.mall.model.vo.*;
import com.ultraneos.mall.service.OrdersService;
import com.ultraneos.mall.util.Constant;
import com.ultraneos.mall.util.MybatisUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author Saitama
 * @since 2022/06/28 10:29
 */

public class OrdersServiceImpl implements OrdersService {

    @Override
    public OrderByPageVO getordersByPage(OrdersByPageBO ordersByPageBO) {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        OrdersDao ordersDao = sqlSession.getMapper(OrdersDao.class);
        List<Orders> orders = ordersDao.getOrders(ordersByPageBO);
        List<OrderInfoVO> orderInfoVOS = new ArrayList<>();
        for (Orders order : orders) {
            orderInfoVOS.add(new OrderInfoVO(order.getAmount(),order.getSpecId(),order.getStateId(),order.getGoods(),
                    order.getId(),order.getState(),order.getUserId(),order.getNumber(),
                    new UserOfOrdersVO(order.getAddress(),order.getPhone(),order.getNickname(),order.getReceiver()),
                    order.getSpec()));
        }
        int count = ordersDao.getTotalCount(ordersByPageBO);
        sqlSession.commit();
        sqlSession.close();
        return new OrderByPageVO(orderInfoVOS,count);
    }

    @Override
    public int deleteOrder(String id) {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        OrdersDao ordersDao = sqlSession.getMapper(OrdersDao.class);
        ordersDao.deleteOrdersById(id);
        sqlSession.commit();
        sqlSession.close();
        return 0;
    }

    @Override
    public OrdersVO getOrders(String id) {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        OrdersDao ordersDao = sqlSession.getMapper(OrdersDao.class);
        Orders orders = ordersDao.getOrdersById(id);
        List<SpecVO> specVOS = ordersDao.getSpecByGoodsId(orders.getGoodsId());
        List<States> states = ordersDao.getAllStates();
        OrdersVO ordersVO = new OrdersVO(orders.getAmount(),new SpecVO(orders.getSpecId()),
                orders.getNumber(),orders.getSpecId(),orders.getGoods(),orders.getId(),
                orders.getStateId(),new States(orders.getStateId()),specVOS,states);
        sqlSession.commit();
        sqlSession.close();
        return ordersVO;
    }

    @Override
    public int changeOrder(ChangeOrdersBO changeOrdersBO) {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        OrdersDao ordersDao = sqlSession.getMapper(OrdersDao.class);
        Orders orders = new Orders();
        Spec spec = ordersDao.getSpecById(changeOrdersBO.getSpec());
        States states = ordersDao.getStatesById(changeOrdersBO.getState());
        orders.setStateId(changeOrdersBO.getState());
        orders.setId(Integer.parseInt(changeOrdersBO.getId()));
        orders.setNumber(changeOrdersBO.getNum());
        orders.setSpecId(changeOrdersBO.getSpec());
        orders.setAmount(changeOrdersBO.getNum()*spec.getPrice());
        orders.setSpec(spec.getName());
        orders.setState(states.getName());
        ordersDao.updateOrder(orders);
        sqlSession.commit();
        sqlSession.close();
        return 0;
    }

    @Override
    public int addOrder(AddOrderBO addOrderBO) {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        OrdersDao ordersDao = sqlSession.getMapper(OrdersDao.class);
        GoodsDao goodsDao = sqlSession.getMapper(GoodsDao.class);
        Spec spec = ordersDao.getSpecById(addOrderBO.getGoodsDetailId());
        if(addOrderBO.getNum()>spec.getStockNum()) {
            sqlSession.rollback();
            sqlSession.close();
            return 1000;
        }
        if(addOrderBO.getState()==1){
            spec.setStockNum(spec.getStockNum()-addOrderBO.getNum());
            ordersDao.updateSpecByCart(spec);
        }
        User user = ordersDao.getUser(addOrderBO.getToken());
        States states = ordersDao.getStatesById(addOrderBO.getState());
        GoodsVO goodsVO = goodsDao.getGoodsVOById(spec.getGoodsId());
        Orders orders = new Orders(null,user.getId(),user.getName(),
                user.getRecName(),user.getAddress(),user.getPhoneNum(),goodsVO.getName(),
                goodsVO.getId(),spec.getName(),addOrderBO.getGoodsDetailId(),addOrderBO.getNum(),
                addOrderBO.getAmount(),addOrderBO.getState(),states.getName(),
                Constant.DATE_FORMAT.format(new Date()),null,Constant.NO_COMMENT_CODE);
        int count = ordersDao.AddOrders(orders);
        sqlSession.commit();
        sqlSession.close();
        if (count == 0) {
            return 1000;
        }
        return 0;
    }

    @Override
    public List<GetOrdersByStateVO> getOrdersByUsernameAndState(String token, Integer state) {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        OrdersDao ordersDao = sqlSession.getMapper(OrdersDao.class);
        GoodsDao goodsDao = sqlSession.getMapper(GoodsDao.class);
        List<Orders> ordersList = ordersDao.getOrdersByUsernameAndState(token,state);
        List<GetGoodsByTypeVO> allGoods = goodsDao.getAllGoods();
        Map<Integer,GetGoodsByTypeVO> map = new HashMap<>();
        for (GetGoodsByTypeVO allGood : allGoods) {
            map.put(allGood.getId(),allGood);
        }
        List<GetOrdersByStateVO> getOrdersByStateVOS = new ArrayList<>();
        for (Orders orders : ordersList) {
            GetGoodsByTypeVO goods = map.get(orders.getGoodsId());
            getOrdersByStateVOS.add(new GetOrdersByStateVO(orders.getAmount(),
                    orders.getCreateTime(),orders.getSpecId(),
                    new GoodsOfOrdersVO(orders.getAmount()/orders.getNumber(),
                            goods.getImg(),orders.getSpecId(),goods.getName(),goods.getId(),orders.getSpec()),
                    orders.getId(),orders.getStateId(),orders.isHasComment(),orders.getNumber()));
        }
        return getOrdersByStateVOS.stream()
                .sorted(Comparator.comparing(GetOrdersByStateVO::getCreatetime)
                        .reversed()).collect(Collectors.toList());
    }

    @Override
    public int settleAccount(List<CartBO> cartBOList) {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        OrdersDao ordersDao = sqlSession.getMapper(OrdersDao.class);
        for (CartBO cartBO : cartBOList) {
            Orders ordersById = ordersDao.getOrdersById(String.valueOf(cartBO.getId()));
            Spec spec = ordersDao.getSpecById(ordersById.getSpecId());
            if(cartBO.getGoodsNum()>spec.getStockNum()){
                sqlSession.rollback();
                sqlSession.close();
                return 1000;
            }
            spec.setStockNum(spec.getStockNum() - cartBO.getGoodsNum());
            ordersDao.updateOrderByCart(cartBO);
            ordersDao.updateSpecByCart(spec);
        }
        sqlSession.commit();
        sqlSession.close();
        return 0;
    }

    @Override
    public int pay(String id) {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        OrdersDao ordersDao = sqlSession.getMapper(OrdersDao.class);
        Orders orders = ordersDao.getOrdersById(id);
        Spec spec = ordersDao.getSpecById(orders.getSpecId());
        if(orders.getNumber()>spec.getStockNum()){
            sqlSession.rollback();
            sqlSession.close();
            return 1000;
        }
        spec.setStockNum(spec.getStockNum() - orders.getNumber());
        orders.setStateId(1);
        orders.setState("未发货");
        ordersDao.updateOrder(orders);
        sqlSession.commit();
        sqlSession.close();
        return 0;
    }

    @Override
    public void confirm(String id) {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        OrdersDao ordersDao = sqlSession.getMapper(OrdersDao.class);
        Orders orders = ordersDao.getOrdersById(id);
        orders.setStateId(3);
        orders.setState("已完成订单");
        ordersDao.updateOrder(orders);
        sqlSession.commit();
        sqlSession.close();
    }

    @Override
    public void sendComment(CommentsBO commentsBO) {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        OrdersDao ordersDao = sqlSession.getMapper(OrdersDao.class);
        Spec specById = ordersDao.getSpecById(commentsBO.getGoodsDetailId());
        User user = ordersDao.getUser(commentsBO.getToken());
        Comments comments = new Comments(null,commentsBO.getContent(),commentsBO.getScore(),
                commentsBO.getGoodsId(),specById.getName(),Constant.DATE_FORMAT.format(new Date()),
                user.getNickname(),user.getId(),commentsBO.getOrderId());
        ordersDao.addComments(comments);
        Orders orders = new Orders();
        orders.setHasComment(Constant.COMMENT_CODE);
        ordersDao.updateOrder(orders);
        sqlSession.commit();
        sqlSession.close();
    }
}
