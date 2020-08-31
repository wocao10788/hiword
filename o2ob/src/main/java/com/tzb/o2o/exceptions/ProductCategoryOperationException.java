package com.tzb.o2o.exceptions;

public class ProductCategoryOperationException extends RuntimeException {
    private static final long serialVersionUID=1L;
    public ProductCategoryOperationException(String msg){
        super(msg);
    }
}
