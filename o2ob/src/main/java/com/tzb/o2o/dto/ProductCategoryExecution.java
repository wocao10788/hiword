package com.tzb.o2o.dto;

import com.tzb.o2o.entity.ProductCategory;
import com.tzb.o2o.enums.ProductCategoryStateEnum;

import java.util.List;

public class ProductCategoryExecution {
    //结果状态
    private int state;
    //状态标识
    private String stateInfo;
    // 因为是批量操作,所以使用List
    private List<ProductCategory> productCategoryList;

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getStateInfo() {
        return stateInfo;
    }

    public void setStateInfo(String stateInfo) {
        this.stateInfo = stateInfo;
    }

    public List<ProductCategory> getProductCategoryList() {
        return productCategoryList;
    }

    public void setProductCategoryList(List<ProductCategory> productCategoryList) {
        this.productCategoryList = productCategoryList;
    }

    public ProductCategoryExecution(int state, String stateInfo){
        this.state=state;
        this.stateInfo=stateInfo;
    }
    // 操作失败时使用的构造器
    public ProductCategoryExecution(ProductCategoryStateEnum stateEnum){
        this.state=stateEnum.getState();
        this.stateInfo=stateEnum.getStateInfo();
    }
    // 操作成功的时候使用的构造器
    public ProductCategoryExecution(ProductCategoryStateEnum stateEnum,
                                    List<ProductCategory> productCategoryList){
        this.state=stateEnum.getState();
        this.stateInfo=stateEnum.getStateInfo();
        this.productCategoryList=productCategoryList;

    }
}

