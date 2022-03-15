package com.wzb.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wzb.entity.menu;
import com.wzb.entity.student;
import com.wzb.service.studentService;
import com.wzb.util.ExportExcelUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.constraints.NotNull;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

@Api(value="学生controller",tags={"学生操作接口"})
@Controller
@Validated
public class studentController {
    @Autowired
    studentService studentService;

    @Autowired
    com.wzb.service.menuService menuService;

    @ResponseBody
    @GetMapping("/getAll")
    @ApiOperation("查询所有学生")
    public List<student> getAll(){
        return  studentService.getAll();
    }

    @ResponseBody
    @GetMapping("/getAllUsePaging")
    @ApiOperation("查询所有学生,使用分页")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "page", value = "页数", required = true),
            @ApiImplicitParam(paramType = "query", name = "limit", value = "条数", required = true)
    })
    public List<student> getAllUsePaging(Integer page,Integer limit){
        List<student> allUsePaging = studentService.getAllUsePaging(page, limit);
        return  allUsePaging;
    }

    @ResponseBody
    @GetMapping("/selectPageVo")
    @ApiOperation("分页查询所有学生")
    public IPage<student> selectPageVo(@RequestParam(name="page", defaultValue="1") Integer pageNo,
                                       @RequestParam(name="limit", defaultValue="10") Integer limit){
        Page<student> page = new Page<student>(pageNo, limit);
        IPage<student> pageList = studentService.selectPageVo(page,1);

        return  pageList;
    }

    @ResponseBody
    @ApiImplicitParam(name = "sid", value = "学生id", required = true, dataType = "String", paramType = "path")
    @ApiOperation("根据id查询学生")
    @GetMapping("/getBysid/{sid}")
    public student getBysid(@PathVariable("sid") @NotNull(message = "用户id不能为空") String sid){
        return studentService.getBysid(Integer.valueOf(sid));
    }

    @ResponseBody
    @ApiOperation("添加一个学生")
    @PostMapping("/addstu")
    public Integer addstu(@Validated @RequestBody student stu){
        return studentService.addStudent(stu);
    }

    @ResponseBody
    @ApiOperation("修改一个学生")
    @PostMapping("/updatestu")
    public Integer updatestu(@Validated @RequestBody student stu){
        return studentService.updateStudent(stu);
    }

    @ResponseBody
    @ApiOperation("根据id删除学生")
    @DeleteMapping("/delstu")
    public Integer deletestu(@RequestBody Integer sid){
        return studentService.deletestuById(sid);
    }

    @ResponseBody
    @ApiOperation("修改一个学生,传入属性")
    @PostMapping("/updatestu2")
    public Integer updatestu2(@RequestParam Integer sid,@RequestParam String sname,@RequestParam String sage,@RequestParam String sex,@RequestParam String phone){
        student stu=new student(sid,sname,sage,sex,phone);
        return studentService.updateStudent(stu);
    }

    /**
     * 导出数据多个sheet
     */
    @ResponseBody
    @ApiOperation("导出数据多个sheet")
    @GetMapping("/export2")
    public void export2(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // 获取多个数据集
        List<student> list =studentService.getAll();
        List<menu> lsParamList =menuService.getAll();
        String fileName = "一次导出多个sheet.xlsx";
        try {
            // 设置浏览器属性，控制浏览器下载
            response.setHeader("Content-Disposition", "attachment; filename="+new String(fileName.getBytes("gb2312"), "ISO8859-1"));
            response.setHeader("Connection", "close");
            response.setHeader("Content-Type", "application/vnd.ms-excel;charset=UTF-8");
            // 定义输出流
            OutputStream ouputStream = response.getOutputStream();

            // 处理查到的数据集合
            List<List<String>> data0 = new ArrayList<List<String>>();
            for (student stu:list){
                List rowData = new ArrayList();
                rowData.add(String.valueOf(stu.getSid()));
                rowData.add(String.valueOf(stu.getSname()));
                rowData.add(String.valueOf(stu.getSage()));
                rowData.add(String.valueOf(stu.getSex()));
                rowData.add(String.valueOf(stu.getPhone()));
                data0.add(rowData);
            }
            List<List<String>> data1 = new ArrayList<List<String>>();
            for (menu m:lsParamList){
                List rowData = new ArrayList();
                rowData.add(String.valueOf(m.getId()));
                rowData.add(String.valueOf(m.getName()));
                rowData.add(String.valueOf(m.getText()));
                rowData.add(String.valueOf(m.getUrl()));
                rowData.add(String.valueOf(m.getParentId()));
                data1.add(rowData);
            }

            // sheet 的文件标题
            String[] headers0 = { "学生id","学生姓名", "学生年龄","学生性别","学生手机号"};
            String[] headers1 = { "id","名称", "描述","url","父id"};
            // 工具类
            ExportExcelUtils eeu = new ExportExcelUtils();
            XSSFWorkbook workbook = new XSSFWorkbook();
            eeu.exportExcel(workbook, 0, "学生sheet", headers0, data0, ouputStream);
            eeu.exportExcel(workbook, 1, "菜单sheet", headers1, data1, ouputStream);

            //原理就是将所有的数据一起写入，然后再关闭输入流。
            workbook.write(ouputStream);
            ouputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 导入excel，读取excel数据
     * @return
     */
    @ApiOperation(value = "导入excel,读取数据", notes = "返回读取数据", produces = "application/json")
    @PostMapping("/importExcel")
    @ResponseBody
    public List<student> importExcel(@RequestParam("file") MultipartFile file) throws IOException {
        return  studentService.importExcel(file);
    }



}