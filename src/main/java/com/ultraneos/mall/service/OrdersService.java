package com.ultraneos.mall.service;

import com.ultraneos.mall.model.bo.*;
import com.ultraneos.mall.model.vo.GetOrdersByStateVO;
import com.ultraneos.mall.model.vo.OrderByPageVO;
import com.ultraneos.mall.model.vo.OrdersVO;

import java.util.List;

public interface OrdersService {

    OrderByPageVO getordersByPage(OrdersByPageBO ordersByPageBO);

    int deleteOrder(String id);

    OrdersVO getOrders(String id);

    int changeOrder(ChangeOrdersBO changeOrdersBO);

    int addOrder(AddOrderBO addOrderBO);

    List<GetOrdersByStateVO> getOrdersByUsernameAndState(String token, Integer state);

    int settleAccount(List<CartBO> cartBOList);

    int pay(String id);

    void confirm(String id);

    void sendComment(CommentsBO commentsBO);
}
