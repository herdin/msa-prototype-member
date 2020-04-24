package com.jsm.mapper;

import com.jsm.dto.model.TestModel;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface TestMapper {
    //@Select("SELECT * FROM TESTID")
    List<TestModel> getAllTest();

    //@Insert("INSERT INTO TESTID VALUES (#{id}, #{name})")
    int addTest(TestModel testModel);
}