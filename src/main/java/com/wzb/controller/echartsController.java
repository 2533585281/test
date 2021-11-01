package com.wzb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.swing.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author Administrator
 * @Date 2021/8/30 0030 10:01
 */
@RequestMapping("echar")
@Controller
public class echartsController {
    @ResponseBody
    @RequestMapping("/getdate")
    public List<pie> getdate (){
        List<pie> plist=new ArrayList<>();
        plist.add(new pie(3,"3333"));
        plist.add(new pie(4,"4444"));
        plist.add(new pie(6,"6666"));

        return plist;
    }



}

class pie extends SizeRequirements {
    private Integer value;
    private String name;

    public pie() {
    }

    public pie(Integer value, String name) {
        this.value = value;
        this.name = name;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
