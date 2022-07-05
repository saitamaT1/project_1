package com.ultraneos.mall.dao;

import com.ultraneos.mall.model.bo.CartBO;
import com.ultraneos.mall.model.bo.OrdersByPageBO;
import com.ultraneos.mall.model.po.*;
import com.ultraneos.mall.model.vo.SpecVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OrdersDao {

    List<Orders> getOrders(@Param("bo") OrdersByPageBO ordersByPageBO);

    void deleteOrdersById(@Param("id") String id);

    int getTotalCount(@Param("bo") OrdersByPageBO ordersByPageBO);

    Orders getOrdersById(@Param("id") String id);

    List<SpecVO> getSpecByGoodsId(@Param("gId") Integer goodsId);

    List<States> getAllStates();

    Spec getSpecById(@Param("id") int spec);

    void updateOrder(@Param("o") Orders orders);

    States getStatesById(@Param("id") int state);

    User getUser(@Param("token") String token);

    int AddOrders(Orders orders);

    List<Orders> getOrdersByUsernameAndState(@Param("token") String token, @Param("state") Integer state);

    void updateOrderByCart(@Param("cartBO") CartBO cartBO);

    void updateSpecByCart(@Param("spec") Spec spec);

    void addComments(Comments comments);
}
