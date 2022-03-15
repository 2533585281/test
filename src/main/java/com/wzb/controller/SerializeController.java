package com.wzb.controller;

import com.wzb.entity.serialize;
import com.wzb.entity.unSerialize;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author Administrator
 * @Date 2022/3/11 0011 10:55
 */
@Controller
public class SerializeController {

    @ResponseBody
    @GetMapping("/getUnSerialize")
    @ApiOperation("获取没有序列化的实体")
    public unSerialize getUnSerialize(){
        unSerialize usl=new unSerialize();
        usl.setId("1");

        return usl;
    }


    @ResponseBody
    @GetMapping("/getSerialize")
    @ApiOperation("获取序列化的实体")
    public serialize getSerialize(){
        serialize sl=new serialize();
        sl.setId("1");

        return sl;
    }
}
