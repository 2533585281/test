package com.wzb.test;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.util.ListUtils;
import com.wzb.entity.DemoData;
import com.wzb.util.TestFileUtil;
import lombok.extern.slf4j.Slf4j;

import java.util.Date;
import java.util.List;

/**
 * @Author Administrator
 * @Date 2021/11/24 0024
 * 静态方法调用静态方法
 * 单元测试不能调用静态方法
 * Excel 简单写入
 */
@Slf4j
public class simpleWrite {
    public static void main(String[] args) {
        // 写法1 JDK8+
        // since: 3.0.0-beta1
        // 生成文件在项目的相对目录
        String fileName = TestFileUtil.getPath() + "simpleWrite" + System.currentTimeMillis() + ".xlsx";
        // 指定文件生成目录
        //String fileName = "c:/simpleWrite" + System.currentTimeMillis() + ".xlsx";
        // 这里 需要指定写用哪个class去写，然后写到第一个sheet，名字为模板 然后文件流会自动关闭
        // 如果这里想使用03 则 传入excelType参数即可
        EasyExcel.write(fileName, DemoData.class)
                .sheet("模板")
                .doWrite(() -> {
                    // 分页查询数据
                    return data();
                });
    }

    private static List<DemoData> data() {
        List<DemoData> list = ListUtils.newArrayList();
        for (int i = 0; i < 10; i++) {
            DemoData data = new DemoData();
            data.setString("字符串" + i);
            data.setDate(new Date());
            data.setDoubleData(0.56);
            list.add(data);
        }
        return list;
    }
}
