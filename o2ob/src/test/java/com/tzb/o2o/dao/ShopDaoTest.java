package com.tzb.o2o.dao;


import com.tzb.o2o.entity.Area;
import com.tzb.o2o.entity.PersonInfo;
import com.tzb.o2o.entity.Shop;
import com.tzb.o2o.entity.ShopCategory;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class ShopDaoTest {
    @Autowired
    private ShopDao shopDao;
    @Test
    public void testQueryShopList(){
        Shop shopCondition=new Shop();
        ShopCategory childCategory=new ShopCategory();
        ShopCategory parentCategory=new ShopCategory();
        parentCategory.setShopCategoryId(12L);
        childCategory.setParent(parentCategory);
        shopCondition.setShopCategory(childCategory);
        List<Shop> shopList=shopDao.queryShopList(shopCondition,0,6);
        int count=shopDao.queryShopCount(shopCondition);
        System.out.println("店铺列表的大小"+shopList.size());
        System.out.println("店铺总数："+count);
//        ShopCategory sc = new ShopCategory();
//        sc.setShopCategoryId(1L);
//        shopCondition.setShopCategory(sc);
//        shopList = shopDao.queryShopList(shopCondition, 0, 5);
//        count = shopDao.queryShopCount(shopCondition);
//
//        System.out.println("新店铺列表大小：" + shopList.size());
//        System.out.println("新店铺数量：" + count);

    }
    @Test
    @Ignore
    public void testQueryByShopId(){
        long shopId=1;
        Shop shop=shopDao.queryByShopId(shopId);
        System.out.println("areaId:"+shop.getArea().getAreaId());
        System.out.println("areaName:"+shop.getArea().getAreaName());
    }

    @Test
    @Ignore
    public void testInsertShop(){
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
        shop.setShopName("我爱你");
        shop.setShopDesc("test");
        shop.setPhone("test");
        shop.setShopImg("test");
        shop.setCreateTime(new Date());
        shop.setEnableStatus(1);
        shop.setAdvice("审核中");
        int effectedNum=shopDao.insertShop(shop);
        assertEquals(1,effectedNum);
    }
    @Test
    @Ignore
    public void testUpdateShop(){
        Shop shop=new Shop();
        shop.setShopName("测试的店铺");
        shop.setShopId(1L);
        shop.setShopDesc("测试描述123123");
        shop.setShopAddr("测试地址");
        shop.setLastEditTime(new Date());
        int effectedNum=shopDao.updateShop(shop);
        assertEquals(1,effectedNum);
    }
}
