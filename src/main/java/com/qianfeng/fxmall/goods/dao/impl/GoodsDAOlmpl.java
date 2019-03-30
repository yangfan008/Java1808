package com.qianfeng.fxmall.goods.dao.impl;

import com.qianfeng.fxmall.commons.info.SystemConstantsUtils;
import com.qianfeng.fxmall.commons.mybotis.MyBatisSessionFactoryUtils;
import com.qianfeng.fxmall.goods.bean.WxbGood;
import com.qianfeng.fxmall.goods.dao.IGoodDAO;
import com.qianfeng.fxmall.goods.mapper.GoodsMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.util.List;

/**
 * mybatis的商品数据访问层
 * 注意
 * 异常在dao层不要捕获
 */
public class GoodsDAOlmpl implements IGoodDAO {

    @Override
    public List<WxbGood> queryGoodsByPage(Integer page) throws Exception {

        SqlSession session = MyBatisSessionFactoryUtils.getSession();
        GoodsMapper goodsMapper = session.getMapper(GoodsMapper.class);
         List<WxbGood> goods = goodsMapper.queryGoodsByPage(page, SystemConstantsUtils.PAGE.PAGE_SIZE);
       return goods;
    }
}
