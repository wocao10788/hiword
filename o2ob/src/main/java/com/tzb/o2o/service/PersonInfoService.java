package com.tzb.o2o.service;

import com.tzb.o2o.entity.PersonInfo;

public interface PersonInfoService {
    /**
     * 根据用户Id获取personInfo信息
     * @param userId
     * @return
     */
    PersonInfo getPersonInfoById(Long userId);
}
