package com.tzb.o2o.dao;


import com.tzb.o2o.entity.PersonInfo;
import com.tzb.o2o.entity.WechatAuth;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

import static org.junit.Assert.assertEquals;
@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class WechatAuthDaoTest  {
    @Autowired
    private WechatAuthDao wechatAuthDao;
    @Test
    public void testAInsertWechatAuth() throws Exception{
        WechatAuth wechatAuth=new WechatAuth();
        PersonInfo personInfo=new PersonInfo();
        personInfo.setUserId(1L);
        wechatAuth.setPersonInfo(personInfo);
        wechatAuth.setOpenId("datahizhfdhaih");
        wechatAuth.setCreateTime(new Date());
        int effectedNum=wechatAuthDao.insertWechatAuth(wechatAuth);
        assertEquals(1,effectedNum);
    }
    @Test
    public void testBQueryWechatAuthByOpenId() throws Exception{
        WechatAuth wechatAuth=wechatAuthDao.queryWechatInfoByOpenId("datahizhfdhaih");
        System.out.println(wechatAuth.getPersonInfo().getName());
        assertEquals("测试",wechatAuth.getPersonInfo().getName());
    }
}
