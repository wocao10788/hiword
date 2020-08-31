package com.tzb.o2o.dao;


import com.tzb.o2o.entity.ProductCategory;
import junit.framework.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ProductCategoryDaoTest {
   @Autowired
   private ProductCategoryDao productCategoryDao;
    @Test
    public void testBQueryByShopId() throws Exception{
        long shopId=1L;
        List<ProductCategory> productCategoryList = productCategoryDao.queryProductCategoryList(shopId);
        System.out.println("该类别的数量为：" + productCategoryList.size());
    }
    @Test
    public void testABathInsertProductCategory(){
        ProductCategory productCategory=new ProductCategory();
        productCategory.setProductCategoryName("商品类别1");
        productCategory.setPriority(1);
        productCategory.setCreateTime(new Date());
        productCategory.setShopId(1L);
        ProductCategory productCategory2=new ProductCategory();
        productCategory2.setProductCategoryName("商品类别2");
        productCategory2.setPriority(1);
        productCategory2.setCreateTime(new Date());
        productCategory2.setShopId(1L);
        List<ProductCategory> productCategoryList=new ArrayList<ProductCategory>();
        productCategoryList.add(productCategory);
        productCategoryList.add(productCategory2);
        int effectedNum=productCategoryDao.batchInsertProductCategory(productCategoryList);
        Assert.assertEquals(2,effectedNum);
    }
    @Test
    public void testCDeleteCProductCategory() throws Exception{
        long shopId=1;
        List<ProductCategory> productCategoryList=productCategoryDao.queryProductCategoryList(shopId);
        for (ProductCategory pc:productCategoryList){
            if ("商品类别1".equals(pc.getProductCategoryName())||"商品类别2".equals(pc.getProductCategoryName()));
                int effectedNum=productCategoryDao.deleteProductCategory(pc.getProductCategoryId(),shopId);
                Assert.assertEquals(1,effectedNum);
        }
    }
}

