package com.example.parkingmanagesys.DAO;

import com.example.parkingmanagesys.Pojo.Special;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SpecialMapper {
    Special selectByCarId(String carId);
    Special selectBySpaceId(Integer spaceId);
    Boolean insertSpecial(Special special);
    Boolean deleteByCarId(String carId);
}
