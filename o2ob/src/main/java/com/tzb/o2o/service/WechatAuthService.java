package com.tzb.o2o.service;

import com.tzb.o2o.dto.WechatAuthExecution;
import com.tzb.o2o.entity.WechatAuth;
import com.tzb.o2o.exceptions.WechatAuthOperationException;

public interface WechatAuthService {
    /**
     * 通过openId查找平台对应的微信账号
     * @param openId
     * @return
     */
    WechatAuth getWechatAuthByOpenId(String openId);

    WechatAuthExecution register(WechatAuth wechatAuth)throws WechatAuthOperationException;
}
