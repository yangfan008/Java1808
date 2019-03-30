package com.qianfeng.fxmall;

import com.qianfeng.fxmall.goods.bean.WxbGood;
import com.qianfeng.fxmall.goods.dao.impl.GoodsDAOlmpl;

import java.util.List;

public class Test1 {
    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                GoodsDAOlmpl goodsDAO = new GoodsDAOlmpl();
                try {
                    List<WxbGood> goods = goodsDAO.queryGoodsByPage(0);
                    goods.get(0).setGoodName("千锋");
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        }).start();
    }

}
