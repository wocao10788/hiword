package com.tzb.o2o.service;

import com.tzb.o2o.entity.ShopCategory;

import java.util.List;

public interface ShopCategoryService {
    public static final String SCLISTKEY = "shopcategorylist";
    /**
     * 根据查询条件获取ShopCategory列表
     * @param shopCategory
     * @return
     */
    List<ShopCategory> getShopCategoryList(ShopCategory shopCategory);
}
