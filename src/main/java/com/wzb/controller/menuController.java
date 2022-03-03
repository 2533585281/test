package com.wzb.controller;

import com.wzb.entity.menu;
import com.wzb.service.menuService;
import io.swagger.annotations.Api;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author Administrator
 * @Date 2021/12/7 0007
 */
@Api(value="菜单controller",tags={"查询菜单树"})
@Controller
@RequestMapping("/menu")
public class menuController {

    @Resource
    menuService menuService;

    @ResponseBody
    @GetMapping("/getAll")
    public List<menu> getAll(){
        return menuService.getAll();
    }

    @ResponseBody
    @GetMapping("/getTree")
    public List<menu> getTree(){
        return menuService.getTree();
    }

    @ResponseBody
    @GetMapping("/getTreeGetEntity")
    public menu getTreeGetEntity(){
        return menuService.getTreeGetEntity();
    }

}
