package com.tzb.o2o.service;

import com.tzb.o2o.dto.ImageHolder;
import com.tzb.o2o.dto.ShopExecution;
import com.tzb.o2o.entity.Area;
import com.tzb.o2o.entity.PersonInfo;
import com.tzb.o2o.entity.Shop;
import com.tzb.o2o.entity.ShopCategory;
import com.tzb.o2o.enums.ShopStateEnum;
import com.tzb.o2o.exceptions.ShopOperationException;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Service;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Date;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ShopServiceTest  {


        @Autowired
        private ShopService shopService;
        @Test
        public void testGetShopList(){
            Shop shoCondition=new Shop();
            ShopCategory sc = new ShopCategory();
            sc.setShopCategoryId(1L);
            shoCondition.setShopCategory(sc);
            ShopExecution se=shopService.getShopList(shoCondition,2,5);
            System.out.println("店铺列表数"+se.getShopList().size());
            System.out.println("店铺总数"+se.getCount());
        }
        @Test
        @Ignore
        public void testModifyShop()throws ShopOperationException,FileNotFoundException{
            Shop shop=new Shop();
            shop.setShopId(1L);
            shop.setShopName("修改后的店铺名称");
            File shopImg=new File("C:\\Users\\Administrator\\Desktop\\1.jpg");
            InputStream is=new FileInputStream(shopImg);
            ImageHolder imageHolder=new ImageHolder("1.jpg",is);
            ShopExecution shopExecution=shopService.modifyShop(shop,imageHolder);
            System.out.println("新的图片地址为："+shopExecution.getShop().getShopImg());
        }
        @Test
        @Ignore
        public void testAddShop() throws FileNotFoundException {
            Shop shop=new Shop();
            PersonInfo owner = new PersonInfo();
            Area area=new Area();
            ShopCategory shopCategory=new ShopCategory();
            owner.setUserId(1L);
            area.setAreaId(2);
            shopCategory.setShopCategoryId(1l);
            shop.setOwner(owner);
            shop.setArea(area);
            shop.setShopCategory(shopCategory);
            shop.setShopName("测试3");
            shop.setShopDesc("test3");
            shop.setPhone("test3");
            shop.setShopImg("test3");
            shop.setCreateTime(new Date());
            shop.setEnableStatus(ShopStateEnum.CHECK.getState());
            shop.setAdvice("审核中");

            File shopImg = new File("D:\\test.jpg");
            InputStream is=new FileInputStream(shopImg);
            ImageHolder imageHolder=new ImageHolder(shopImg.getName(),is);
            ShopExecution se = shopService.addShop(shop,imageHolder);
            assertEquals(ShopStateEnum.CHECK.getState(),se.getState());

        }


    }


