package com.wossha.clothing.infrastructure.mapper;

import org.dozer.DozerBeanMapper;
import org.dozer.DozerBeanMapperSingletonWrapper;
import org.dozer.Mapper;

import com.wossha.clothing.commands.clothing.createClothe.model.Clothe;
import com.wossha.clothing.dto.ClotheDTO;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class MapperDozer {

    protected static Mapper mapper = DozerBeanMapperSingletonWrapper.getInstance();

    static {
        ArrayList<String> mappingfileUrls = new ArrayList<>();
        mappingfileUrls.add("dozer/dozerClothingMapping.xml");
        ((DozerBeanMapper) mapper).setMappingFiles(mappingfileUrls);
    }

    public <T> T map(Object source, Class<T> destinationClass){
        return mapper.map(source, destinationClass);
    }

    public ClotheDTO mapClotheDTOToClothe(Clothe cl){
        return mapper.map(  cl,  ClotheDTO.class);
    }
}
