package com.tzb.o2o.service;

import com.tzb.o2o.entity.HeadLine;

import java.util.List;

public interface HeadLineService {
    public static final String HLLISTKEY = "headlinelist";

    public List<HeadLine> getHeadLineList(HeadLine headLineCondition)throws Exception;

}
