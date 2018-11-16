package com.henu.main.controller;

import com.alibaba.fastjson.JSON;
import com.henu.main.entities.History;
import com.henu.main.entities.Teacher;
import com.henu.main.service.HistoryService;
import com.henu.main.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin
public class TeacherController {

    @Autowired
    TeacherService teacherService;

    @Autowired
    HistoryService historyService;

    @RequestMapping("/selectAll")
    public String selectAll(@RequestBody String input) {
        History history = History.getInstance();
        history.setName("selectAll");
        String out = "";
        try {
            Long timeForCalculate1 = System.nanoTime();
            // -------------------------业务逻辑代码部分-------------------------

            out = teacherService.selectAll();

            // -------------------------业务逻辑代码部分-------------------------
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//可以方便地修改日期格式
            Long timeForCalculate2 = System.nanoTime();
            Double timeForCalculate3 = (timeForCalculate2 - timeForCalculate1) / Math.pow(10, 6);
            String now = dateFormat.format(new Date());
            System.out.println(now + "\t\t调用 selectAll 方法" + System.getProperty("line.separator") +
                    "----> 传入的数据为\t\t" + input + System.getProperty("line.separator") +
                    "----> 共经历的时间\t\t" + timeForCalculate3 + "毫秒" + System.getProperty("line.separator") +
                    "----> 传出的数据为\t\t" + out + System.getProperty("line.separator"));
            out = "{\"time\":\"" + timeForCalculate3 + "\"}";
            history.setInput(input);
            history.setTime(now);
            history.setOutput(out);
            history.setUser("系统测试员");
            return out;
        } finally {
            historyService.insertSelective(history);
        }
    }

}
