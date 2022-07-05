package com.ultraneos.mall.dao;

import com.ultraneos.mall.model.bo.AddSpecBO;
import com.ultraneos.mall.model.bo.AskMsgBO;
import com.ultraneos.mall.model.bo.MsgReplyBO;
import com.ultraneos.mall.model.bo.UpdateGoodsSpecBO;
import com.ultraneos.mall.model.po.*;
import com.ultraneos.mall.model.vo.*;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GoodsDao {

    List<Type> getType();

    List<GetGoodsByTypeVO> getGoodsByType(@Param("id") Integer id);

    int addGoods(@Param("g") Goods goods);

    int addSpecList(@Param("id") int id, @Param("specs") List<Spec> specList);

    void addType(@Param("type") Type type);

    int deleteTypeById(@Param("id") Integer id);

    GoodsVO getGoodsVOById(@Param("id") Integer id);

    List<SpecVO> getSpecVOByGoodsId(@Param("id") Integer id);

    int addSpecByGoodsId(@Param("bo") AddSpecBO addSpecBO);

    int deleteSpec(@Param("bo") AddSpecBO addSpecBO);

    void updateGoods(@Param("g") Goods goods);

    int deleteGoodsById(@Param("id") Integer id);

    void deleteSpecById(@Param("id") Integer id);

    List<String> getspecNamesByGoodsId(@Param("id") Integer goodsId);

    List<GetGoodsByTypeVO> getGoodsByName(@Param("key") String keyword);

    List<GetGoodsByTypeVO> getAllGoods();

    List<Msg> getNoReplyMsg(@Param("no") int noReplyCode);

    void updateMsg(@Param("BO") MsgReplyBO msgReplyBO, @Param("date") String date);

    List<Msg> getMsgByGoodsId(@Param("id") Integer id);

    void addMsg(Msg msg);

    List<Comments> getCommentsByGoodsId(@Param("goodsId") Integer goodsId);

    void addSpecByGoodsIdAndSpec(@Param("BOS") List<UpdateGoodsSpecBO> updateGoodsSpecBOS, @Param("id") Integer id);
}
