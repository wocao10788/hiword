package com.tzb.o2o.service.impl;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tzb.o2o.cache.JedisUtil;
import com.tzb.o2o.dao.AreaDao;
import com.tzb.o2o.entity.Area;
import com.tzb.o2o.exceptions.AreaOperationException;
import com.tzb.o2o.service.AreaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class AreaServiceImpl implements AreaService {

    @Autowired
    private AreaDao areaDao;
    @Autowired
    private JedisUtil.Keys jedisKeys;
    @Autowired
    private JedisUtil.Strings jedisStrings;

    private static Logger logger= LoggerFactory.getLogger(AreaServiceImpl.class);
    @Override
    public List<Area> getAreaList() {
        String key=AREALISTKEY;
        List<Area> areaList=null;
        ObjectMapper mapper=new ObjectMapper();
        if (!jedisKeys.exists(key)){
            areaList=areaDao.queryArea();
            String jsonString= null;
            try {
                jsonString = mapper.writeValueAsString(areaList);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
                logger.error(e.getMessage());
                throw new AreaOperationException(e.getMessage());
            }
            jedisStrings.set(key,jsonString);
        }else {
            // 若存在，则直接从redis里面取出相应数据
            String jsonString=jedisStrings.get(key);
            // 指定要将string转换成的集合类型
            JavaType javaType=mapper.getTypeFactory().constructParametricType(ArrayList.class, Area.class);
            try {
                // 将相关key对应的value里的的string转换成对象的实体类集合
                areaList=mapper.readValue(jsonString,javaType);
            } catch (JsonParseException e) {
                e.printStackTrace();
                logger.error(e.getMessage());
                throw new AreaOperationException(e.getMessage());
            } catch (JsonMappingException e) {
                e.printStackTrace();
                logger.error(e.getMessage());
                throw new AreaOperationException(e.getMessage());
            } catch (IOException e) {
                e.printStackTrace();
                logger.error(e.getMessage());
                throw new AreaOperationException(e.getMessage());
            }
        }
        return areaList;
    }
}
