package com.wzb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author Administrator
 * @Date 2021/7/27 0027 11:03
 * 访问业务二必须先访问业务一，获取凭证  修改手机号场景
 * localhost:8888/yewu1?phone="12345678910"
 */
@Controller
public class yewuController {

    Map<String,Boolean> map=new HashMap<>();

    @GetMapping("yewu1")
    @ResponseBody
    public String yewu1(String phone){
        map.put(phone,true);
        return "这里是业务1";
    }

    @GetMapping("yewu2")
    @ResponseBody
    public String yewu2(String phone){
    try{
        if(map.get(phone)){
            return "如果是true,你就能看到我。";
        }else if(map.get(phone)){
            return "请去访问业务一";
        }

        return "这里是业务2";
    }catch (NullPointerException e){
        return "您的信息没有被记录";
    }
    }


}
