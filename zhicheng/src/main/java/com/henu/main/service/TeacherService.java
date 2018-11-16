package com.henu.main.service;

import com.alibaba.fastjson.JSON;
import com.henu.main.entities.Teacher;
import com.henu.main.mapper.TeacherMapper;
import com.henu.main.util.ApplicationInit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;

@Service
public class TeacherService {

    @Autowired
    TeacherMapper teacherMapper;

    @Transactional
    public String selectAll() {
        HashMap<String, String> memoryDatabase = ApplicationInit.getMemoryDatabase();
        if (memoryDatabase.containsKey("teachers")) {
            return memoryDatabase.get("teachers");
        } else {
            String result = JSON.toJSONString(teacherMapper.selectAll());
            memoryDatabase.put("teachers", result);
            return result;
        }
    }

}
