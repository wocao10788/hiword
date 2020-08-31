package com.tzb.o2o.dao;

import com.tzb.o2o.entity.PersonInfo;
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
public class PersonInfoDaoTest  {
    @Autowired
    private PersonInfoDao personInfoDao;
    @Test
    public void testAInsertPersonInfo() throws Exception{
        PersonInfo personInfo=new PersonInfo();
        personInfo.setName("我爱你");
        personInfo.setGender("女");
        personInfo.setUserType(1);
        personInfo.setCreateTime(new Date());
        personInfo.setLastEditTime(new Date());
        personInfo.setEnableStatus(1);
        int effectedNum=personInfoDao.insertPersonInfo(personInfo);
        assertEquals(1,effectedNum);
    }
    @Test
    public void testBQueryPersonInfoById(){
        long userId=1;
        PersonInfo person=personInfoDao.queryPersonInfoById(userId);
        System.out.println(person.getName());
    }
}