package com.wzb.controller;

import com.wzb.util.RedisUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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

    /**
     * 根据key查询对应的value
     * @param key
     * @return
     */
    @ResponseBody
    @ApiOperation("根据key查询对应的value")
    @GetMapping("/getKey/{key}")
    @ApiImplicitParam(name = "key", value = "key", required = true, dataType = "String", paramType = "path")
    public String getKey(@PathVariable("key")String key){
        String s=redisUtils.get(key);
        System.out.println(s);
        return s;
    }

    /**
     * 添加一条数据到redis,key作为key,value作为value
     * @param key
     * @param value
     * @return
     */
    @ResponseBody
    @ApiOperation("添加一条数据到redis,key作为key,value作为value,或根据key修改value")
    @PostMapping("/addkey")
    public String addkey(@RequestParam String key,@RequestParam String value){
        boolean set = redisUtils.set(key, value);
        if (set){
            return "数据存入成功！";
        }
        return "数据存入失败！";
    }
    /**
     * 根据key查询对应的value
     * @param key
     * @return
     */
    @ResponseBody
    @ApiOperation("根据key删除对应的数据")
    @DeleteMapping("/deletevalue/{key}")
    @ApiImplicitParam(name = "key", value = "key", required = true, dataType = "String", paramType = "path")
    public String deletevalue(@PathVariable("key")String key){
        boolean s=redisUtils.delete(key);
        if (s){
            return "数据删除成功！";
        }
        return "数据删除失败！";
    }

}
