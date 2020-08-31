package com.tzb.o2o.service;

import com.tzb.o2o.dto.ImageHolder;
import com.tzb.o2o.dto.ShopExecution;
import com.tzb.o2o.entity.Shop;
import com.tzb.o2o.exceptions.ShopOperationException;

public interface ShopService {
    /**
     *根据shopCondition分页返回相应店铺列表
     * @param shopCondition
     * @param pageIndex
     * @param pageSize
     * @return
     */
    public ShopExecution getShopList(Shop shopCondition, int pageIndex, int pageSize);
    /**
     * 根据店铺id获取店铺信息
     * @param shopId
     * @return
     */
    Shop getByshopId(long shopId);
    /**
     * 更新店铺信息，包含对图片的处理
     * @param shop
     * @param thumbnail
     * @return
     * @throws ShopOperationException
     */
    ShopExecution modifyShop(Shop shop, ImageHolder thumbnail) throws ShopOperationException;

    ShopExecution addShop(Shop shop, ImageHolder thumbnail) throws ShopOperationException;
}
