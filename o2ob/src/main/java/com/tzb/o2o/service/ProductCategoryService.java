package com.tzb.o2o.service;

import com.tzb.o2o.dto.ProductCategoryExecution;
import com.tzb.o2o.entity.ProductCategory;
import com.tzb.o2o.exceptions.ProductCategoryOperationException;

import java.util.List;

public interface ProductCategoryService {
    List<ProductCategory> queryProductCategoryList(long shopId);

    ProductCategoryExecution batchAddProductCategory
            (List<ProductCategory> productCategoryList) throws ProductCategoryOperationException;
/**
 * 将此类别下的商品里的类别id置为空，再删除掉该商品类别
 * @param productCategoryId
 * @param shopId
 * @return
 * @throws ProductCategoryOperationException
 */
public ProductCategoryExecution deleteProductCategory(long productCategoryId, long shopId)throws ProductCategoryOperationException;
}