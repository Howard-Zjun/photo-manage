package pers.howard.personalspace.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import pers.howard.personalspace.model.PreferenceItem;

@Mapper
public interface PreferenceDao {
    void updatePrefer(@Param("item")PreferenceItem preferenceItem);
    PreferenceItem retrievePrefer(@Param("userID") String userID);
}
