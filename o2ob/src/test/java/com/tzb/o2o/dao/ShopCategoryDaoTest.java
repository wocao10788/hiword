package com.tzb.o2o.dao;


import com.tzb.o2o.entity.ShopCategory;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ShopCategoryDaoTest  {
    @Autowired
    private ShopCategoryDao shopCategoryDao;
    @Test
    public void testQueryShopCategory(){
        List<ShopCategory> shopCategoryList =
                shopCategoryDao.queryShopCategory(null);
        System.out.println(shopCategoryList.size());

//        assertEquals(2, shopCategoryList.size());
//        ShopCategory testCategory = new ShopCategory();
//        ShopCategory parentCategory = new ShopCategory();
//        parentCategory.setShopCategoryId(1L);
//        testCategory.setParent(parentCategory);
//        shopCategoryList = shopCategoryDao.queryShopCategory(testCategory);
//        System.out.println(shopCategoryList.get(0).getShopCategoryName());
    }

}
