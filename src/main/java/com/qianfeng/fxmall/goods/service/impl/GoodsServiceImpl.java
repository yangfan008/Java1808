package com.qianfeng.fxmall.goods.service.impl;

import com.qianfeng.fxmall.commons.info.SystemConstantsUtils;
import com.qianfeng.fxmall.goods.bean.WxbGood;
import com.qianfeng.fxmall.goods.dao.IGoodDAO;
import com.qianfeng.fxmall.goods.dao.impl.GoodsDAOlmpl;
import com.qianfeng.fxmall.goods.service.IGoodsService;

import java.util.List;

public class GoodsServiceImpl implements IGoodsService {
    private IGoodDAO goodsDAO =new GoodsDAOlmpl();
    @Override
    public List<WxbGood> queryGoodsByPage(Integer page) throws Exception {
       if (page<0){
           throw new IndexOutOfBoundsException("页码不能小于1");
       }

       //计算起始下标
       int index=(page-1)* SystemConstantsUtils.PAGE.PAGE_SIZE;

        List<WxbGood> goods = goodsDAO.queryGoodsByPage(page);
        return goods;
    }
}
