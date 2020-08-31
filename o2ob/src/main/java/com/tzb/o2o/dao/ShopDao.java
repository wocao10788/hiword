package com.tzb.o2o.dao;

import com.tzb.o2o.entity.Shop;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ShopDao {
    /**
     * 分页查询店铺
     * 多个参数，Param指定唯一的标识
     * 可输入条件：店铺名（模糊），店铺状态，店铺类别，区域Id,owner
     * @param shopCondition
     * @param rowIndex 从第几行开始取数据
     * @param pageSize 返回的条数
     * @return
     */
    List<Shop> queryShopList(@Param("shopCondition") Shop shopCondition, @Param("rowIndex") int rowIndex, @Param("pageSize") int pageSize);

    /**
     *返回queryShopList总数
     * @param shopCondition
     * @return
     */
    int queryShopCount(@Param("shopCondition") Shop shopCondition);


    Shop queryByShopId(long shopId);
    //    新增店铺
    int insertShop(Shop shop);

    //    更新店铺信息
    int updateShop(Shop shop);
}
