package com.qianfeng.fxmall.goods.dao;

import com.qianfeng.fxmall.goods.bean.WxbGood;

import java.util.List;

public interface IGoodDAO {
    List<WxbGood> queryGoodsByPage(Integer page) throws Exception;
}
