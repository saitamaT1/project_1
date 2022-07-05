package com.ultraneos.mall.model.vo;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Saitama
 * @since 2022/06/29 22:42
 */
@Data
public class OrderByPageVO {
    private  Integer total;
    private List<OrderInfoVO> orders = new ArrayList<>();


    public OrderByPageVO(List<OrderInfoVO> orderInfoVOS, Integer total) {
        this.orders = orderInfoVOS;
        this.total = total;
    }

    public OrderByPageVO(){
    }
}
