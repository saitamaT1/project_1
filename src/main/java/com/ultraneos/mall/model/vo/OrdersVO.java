package com.ultraneos.mall.model.vo;

import com.ultraneos.mall.model.po.States;
import lombok.Data;

import java.util.List;

/**
 * @author Saitama
 * @since 2022/06/30 18:29
 */
@Data
public class OrdersVO {

    /**
     * amount : 80
     * curSpec : {"id":1288}
     * num : 1
     * goodsDetailId : 1288
     * goods : 简约餐桌
     * id : 1764
     * state : 1
     * curState : {"id":1}
     * spec : [{"unitPrice":0,"specName":"单椅","id":1286},{"unitPrice":0,"specName":"单桌","id":1287},{"unitPrice":0,"specName":"两椅组合","id":1288},{"unitPrice":0,"specName":"四椅组合","id":1289}]
     * states : [{"name":"未付款","id":0},{"name":"未发货","id":1},{"name":"已发货","id":2},{"name":"已完成订单","id":3}]
     */
    private Double amount;
    private SpecVO curSpec;
    private int num;
    private int goodsDetailId;
    private String goods;
    private int id;
    private int state;
    private States curState;
    private List<SpecVO> spec;
    private List<States> states;

    public OrdersVO(Double amount, SpecVO curSpec, int num, int goodsDetailId, String goods, int id, int state, States curState, List<SpecVO> spec, List<States> states) {
        this.amount = amount;
        this.curSpec = curSpec;
        this.num = num;
        this.goodsDetailId = goodsDetailId;
        this.goods = goods;
        this.id = id;
        this.state = state;
        this.curState = curState;
        this.spec = spec;
        this.states = states;
    }

    public OrdersVO() {
    }
}
