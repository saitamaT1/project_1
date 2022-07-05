package com.ultraneos.mall.service;

import com.ultraneos.mall.model.bo.*;
import com.ultraneos.mall.model.po.Type;
import com.ultraneos.mall.model.vo.*;

import java.util.List;

public interface GoodsService {

    List<Type> getType();

    List<GetGoodsByTypeVO> getGoodsByType(Integer id);


    /**
     *
     * @param addGoodsBO
     * @return 0 添加成功 ，1000 商品名重复 , 10000 添加失败
     */
    int addGoods(AddGoodsBO addGoodsBO);

    /**
     *
     * @param type
     * @return 0 添加成功 , 10000 添加失败
     */
    int addType(Type type);

    int deleteTypeById(Integer id);

    GoodsInfoVO getGoodsInfo(Integer id);
    /**
     *
     * @param addSpecBO
     * @return 0 添加成功 , 10000 添加失败
     */
    int addSpecById(AddSpecBO addSpecBO);

    /**
     *
     * @param addSpecBO
     * @return 0 删除成功
     */
    int deleteSpec(AddSpecBO addSpecBO);

    int updateGoods(UpdateGoodsBO updateGoodsBO);

    int deleteGoods(Integer id);

    List<GetGoodsByTypeVO> getGoodsByName(String keyword);

    List<GetGoodsByTypeVO> getGoods();

    MallGoodsInfoVO getMallGoodsInfo(Integer id);

    List<MsgVO> getNoReplyMsg(int noReplyCode);

    List<MsgVO> getReplyMsg(int replyCode);

    int updateMsg(MsgReplyBO msgReplyBO);

    List<GoodsMsgVO> getMsg(Integer id);

    void addMsg(AskMsgBO askMsgBO);

    List<CommentsVO> getComments(Integer goodsId);
}
