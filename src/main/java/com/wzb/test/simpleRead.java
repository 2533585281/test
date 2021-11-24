package com.wzb.test;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.read.listener.PageReadListener;
import com.alibaba.fastjson.JSON;
import com.wzb.entity.DemoData;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author Administrator
 * @Date 2021/11/24 0024
 *  * Excel 简单读取
 */
@Slf4j
public class simpleRead {
    public static void main(String[] args) {
        List<DemoData> list=new ArrayList<>();
        String fileName = "E:/MyDemo/test/target/test-classes/simpleWrite1637720640856.xlsx";
        EasyExcel.read(fileName, DemoData.class, new PageReadListener<DemoData>(dataList -> {
            for (DemoData demoData : dataList) {
                list.add(demoData);
                log.info("读取到一条数据{}", JSON.toJSONString(demoData));
            }
        })).sheet().doRead();
//      为内存地址
        System.out.println(list);
//      EasyExcel.read(fileName, DemoData.class, new PageReadListener<DemoData>(System.out::println)).sheet().doRead();
    }

}
