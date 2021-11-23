package com.wzb.controller;

import com.wzb.util.RedisUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * @Author Administrator
 * @Date 2021/11/23 0023
 */
@Api(value="rediscontroller",tags={"redis操作接口"})
@Controller
@RequestMapping("RedisController")
public class redisController {

    @Resource
    RedisUtils redisUtils;

    @ResponseBody
    @GetMapping("getKey/{key}")
    @ApiImplicitParam(name = "key", value = "key", required = true, dataType = "String", paramType = "path")
    public String getKey(@PathVariable("key")String key){
        String s=redisUtils.get(key);
        System.out.println(s);
        return s;
    }
}
