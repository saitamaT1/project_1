package com.ultraneos.mall.service.impl;

import com.ultraneos.mall.dao.GoodsDao;
import com.ultraneos.mall.dao.UserDao;
import com.ultraneos.mall.model.bo.*;
import com.ultraneos.mall.model.po.*;
import com.ultraneos.mall.model.vo.*;
import com.ultraneos.mall.service.GoodsService;
import com.ultraneos.mall.util.Constant;
import com.ultraneos.mall.util.MybatisUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author Saitama
 * @since 2022/06/28 10:29
 */

public class GoodsServiceImpl implements GoodsService {


    @Override
    public List<Type> getType() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        GoodsDao goodsDao = sqlSession.getMapper(GoodsDao.class);
        List<Type> typeList = goodsDao.getType();
        sqlSession.commit();
        sqlSession.close();
        return typeList;
    }

    @Override
    public List<GetGoodsByTypeVO> getGoodsByType(Integer id) {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        GoodsDao goodsDao = sqlSession.getMapper(GoodsDao.class);
        List<GetGoodsByTypeVO> getGoodsByTypeVOS = goodsDao.getGoodsByType(id);
        sqlSession.commit();
        sqlSession.close();
        return getGoodsByTypeVOS;
    }

    @Override
    public int addGoods(AddGoodsBO updateGoodsBO) {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        GoodsDao goodsDao = sqlSession.getMapper(GoodsDao.class);
        List<AddGoodsSpecBO> updateGoodsSpecBOS = updateGoodsBO.getSpecList();
        List<Spec> specList = new ArrayList<>();
        Integer stockNum = updateGoodsSpecBOS.get(0).getStockNum();
        double price = updateGoodsSpecBOS.get(0).getUnitPrice();
        for (int i = 0; i < updateGoodsSpecBOS.size(); i++) {
            if (updateGoodsSpecBOS.get(i).getStockNum() == null ||
                    updateGoodsSpecBOS.get(i).getSpecName().equals("")
                    || updateGoodsSpecBOS.get(i).getUnitPrice() == 0) {
                return 10000;
            }
            if (updateGoodsSpecBOS.get(i).getUnitPrice() < price) {
                price = updateGoodsSpecBOS.get(i).getUnitPrice();
            }
            stockNum += updateGoodsSpecBOS.get(i).getStockNum();
            specList.add(new Spec(null, updateGoodsSpecBOS.get(i).getSpecName(), updateGoodsSpecBOS.get(i).getStockNum(), updateGoodsSpecBOS.get(i).getUnitPrice(), null));
        }
        if (updateGoodsBO.getName().equals("") ||
                updateGoodsBO.getSpecList() == null ||
                updateGoodsBO.getImg().equals("")) {
            return 10000;
        }
        Goods goods = new Goods(null, updateGoodsBO.getName(), updateGoodsBO.getTypeId()
                , updateGoodsBO.getImg(), updateGoodsBO.getDesc(), price, stockNum);
        try {
            goodsDao.addGoods(goods);
        } catch (Exception e) {
            sqlSession.rollback();
            sqlSession.close();
            return 1000;
        }
        int count2 = goodsDao.addSpecList(goods.getId(), specList);
        sqlSession.commit();
        sqlSession.close();
        return 0;
    }

    @Override
    public int addType(Type type) {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        GoodsDao goodsDao = sqlSession.getMapper(GoodsDao.class);
        try {
            goodsDao.addType(type);
        } catch (Exception e) {
            sqlSession.rollback();
            sqlSession.close();
            return 10000;
        }
        sqlSession.commit();
        sqlSession.close();
        return 0;
    }

    //TODO  删除规格
    @Override
    public int deleteTypeById(Integer id) {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        GoodsDao goodsDao = sqlSession.getMapper(GoodsDao.class);
        int count = goodsDao.deleteTypeById(id);
        sqlSession.commit();
        sqlSession.close();
        if (count == 0) {
            return 10000;
        }
        return 0;
    }

    @Override
    public GoodsInfoVO getGoodsInfo(Integer id) {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        GoodsDao goodsDao = sqlSession.getMapper(GoodsDao.class);
        GoodsVO goodsVO = goodsDao.getGoodsVOById(id);
        List<SpecVO> specVOs = goodsDao.getSpecVOByGoodsId(id);
        sqlSession.commit();
        sqlSession.close();
        return new GoodsInfoVO( specVOs,goodsVO);
    }

    @Override
    public int addSpecById(AddSpecBO addSpecBO) {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        GoodsDao goodsDao = sqlSession.getMapper(GoodsDao.class);
        List<String> specNames= goodsDao.getspecNamesByGoodsId(addSpecBO.getGoodsId());
        if(specNames.contains(addSpecBO.getSpecName())){
            sqlSession.commit();
            sqlSession.close();
            return 10000;
        }
        int count = goodsDao.addSpecByGoodsId(addSpecBO);
        sqlSession.commit();
        sqlSession.close();
        if (count == 0) {
            return 10000;
        }
        return 0;
    }

    @Override
    public int deleteSpec(AddSpecBO addSpecBO) {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        GoodsDao goodsDao = sqlSession.getMapper(GoodsDao.class);
        int count = goodsDao.deleteSpec(addSpecBO);
        sqlSession.commit();
        sqlSession.close();
        return 0;
    }

    @Override
    public int updateGoods(UpdateGoodsBO updateGoodsBO) {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        GoodsDao goodsDao = sqlSession.getMapper(GoodsDao.class);
        List<UpdateGoodsSpecBO> updateGoodsSpecBOS = updateGoodsBO.getSpecList();
        Integer stockNum = updateGoodsSpecBOS.get(0).getStockNum();
        double price = updateGoodsSpecBOS.get(0).getUnitPrice();
        for (int i = 0; i < updateGoodsSpecBOS.size(); i++) {
            if (updateGoodsSpecBOS.get(i).getUnitPrice() < price) {
                price = updateGoodsSpecBOS.get(i).getUnitPrice();
            }
            stockNum += updateGoodsSpecBOS.get(i).getStockNum();
        }
        if (updateGoodsBO.getName().equals("") ||
                updateGoodsBO.getSpecList() == null ||
                updateGoodsBO.getImg().equals("")) {
            return 10000;
        }
        int index = updateGoodsBO.getImg().indexOf("static/image");
        Goods goods = new Goods(updateGoodsBO.getId(), updateGoodsBO.getName(), updateGoodsBO.getTypeId()
                , updateGoodsBO.getImg().substring(index), updateGoodsBO.getDesc(), price, stockNum);
        try {
            goodsDao.updateGoods(goods);
            goodsDao.deleteSpecById(goods.getId());
            goodsDao.addSpecByGoodsIdAndSpec(updateGoodsSpecBOS,goods.getId());
        } catch (Exception e) {
            sqlSession.rollback();
            sqlSession.close();
            return 1000;
        }
        sqlSession.commit();
        sqlSession.close();
        return 0;
    }

    @Override
    public int deleteGoods(Integer id) {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        GoodsDao goodsDao = sqlSession.getMapper(GoodsDao.class);
        goodsDao.deleteGoodsById(id);
        goodsDao.deleteSpecById(id);
        sqlSession.commit();
        sqlSession.close();
        return 0;
    }

    @Override
    public List<GetGoodsByTypeVO> getGoodsByName(String keyword) {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        GoodsDao goodsDao = sqlSession.getMapper(GoodsDao.class);
        List<GetGoodsByTypeVO> getGoodsByTypeVOS = goodsDao.getGoodsByName(keyword);
        sqlSession.commit();
        sqlSession.close();
        return getGoodsByTypeVOS;
    }

    @Override
    public List<GetGoodsByTypeVO> getGoods() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        GoodsDao goodsDao = sqlSession.getMapper(GoodsDao.class);
        List<GetGoodsByTypeVO> getGoodsByTypeVOList = goodsDao.getAllGoods();
        sqlSession.commit();
        sqlSession.close();
        return getGoodsByTypeVOList;
    }

    @Override
    public MallGoodsInfoVO getMallGoodsInfo(Integer id) {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        GoodsDao goodsDao = sqlSession.getMapper(GoodsDao.class);
        GoodsVO goodsVO = goodsDao.getGoodsVOById(id);
        List<SpecVO> specVOs = goodsDao.getSpecVOByGoodsId(id);
        sqlSession.commit();
        sqlSession.close();
        return new MallGoodsInfoVO(goodsVO.getUnitPrice(),specVOs,goodsVO.getImg(),goodsVO.getName(),goodsVO.getTypeId(),goodsVO.getDesc());
    }

    @Override
    public List<MsgVO> getNoReplyMsg(int noReplyCode) {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        GoodsDao goodsDao = sqlSession.getMapper(GoodsDao.class);
        List<Msg> msgs = goodsDao.getNoReplyMsg(noReplyCode);
        List<MsgVO> msgVOS=new ArrayList<>();
        for (Msg msg : msgs) {
            msgVOS.add(new MsgVO(msg.getCreateTime(),msg.getGoodsId(),new Goods(msg.getGoods()),msg.getId(),
                    null,msg.getState(),msg.getUserId(),new User(msg.getUsername()),msg.getContent()));
        }
        return msgVOS;
    }

    @Override
    public List<MsgVO> getReplyMsg(int replyCode) {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        GoodsDao goodsDao = sqlSession.getMapper(GoodsDao.class);
        List<Msg> msgs = goodsDao.getNoReplyMsg(replyCode);
        List<MsgVO> msgVOS=new ArrayList<>();
        for (Msg msg : msgs) {
            msgVOS.add(new MsgVO(msg.getCreateTime(),msg.getGoodsId(),new Goods(msg.getGoods()),msg.getId(),
                    msg.getReplyContent(),msg.getState(),msg.getUserId(),new User(msg.getUsername()),msg.getContent()));
        }
        return msgVOS;
    }

    @Override
    public int updateMsg(MsgReplyBO msgReplyBO) {
        if(msgReplyBO.getContent().length()==0){
            return 10000;
        }
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        GoodsDao goodsDao = sqlSession.getMapper(GoodsDao.class);
        goodsDao.updateMsg(msgReplyBO, Constant.DATE_FORMAT.format(new Date()));
        sqlSession.commit();
        sqlSession.close();
        return 0;
    }

    @Override
    public List<GoodsMsgVO> getMsg(Integer id) {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        GoodsDao goodsDao = sqlSession.getMapper(GoodsDao.class);
        List<Msg> msgs = goodsDao.getMsgByGoodsId(id);
        List<GoodsMsgVO> goodsMsgVOS = new ArrayList<>();
        for (Msg msg : msgs) {
            goodsMsgVOS.add(new GoodsMsgVO(msg.getUsername(),msg.getId(),
                    msg.getCreateTime(),new ReplyVO(msg.getRCreateTime(),
                    msg.getReplyContent()),msg.getContent()));
        }
        sqlSession.commit();
        sqlSession.close();
        return goodsMsgVOS;
    }

    @Override
    public void addMsg(AskMsgBO askMsgBO) {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        GoodsDao goodsDao = sqlSession.getMapper(GoodsDao.class);
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        GoodsVO goodsVO = goodsDao.getGoodsVOById(askMsgBO.getGoodsId());
        User user = userDao.getUserByName(askMsgBO.getToken());
        Msg msg =new Msg(null,askMsgBO.getMsg(),null,
                goodsVO.getName(),user.getName(),Constant.DATE_FORMAT.format(new Date()),
                null,Constant.NO_REPLY_CODE,user.getId(),goodsVO.getId());
        goodsDao.addMsg(msg);
        sqlSession.commit();
        sqlSession.close();
    }

    @Override
    public List<CommentsVO> getComments(Integer goodsId) {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        GoodsDao goodsDao = sqlSession.getMapper(GoodsDao.class);
        List<Comments> commentsList = goodsDao.getCommentsByGoodsId(goodsId);
        List<CommentsVO> commentsVOS = new ArrayList<>();
        for (Comments comments : commentsList) {
            commentsVOS.add(new CommentsVO(comments.getScore(),comments.getSpecName(),
                    comments.getComment(),comments.getId(),comments.getTime(),
                    new UserVO(comments.getNickname()),comments.getUserId()));
        }
        sqlSession.commit();
        sqlSession.close();
        return commentsVOS;
    }


}
