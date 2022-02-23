package com.wzb.downfile;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * @Author Administrator
 * @Date 2022/2/23 0023 15:11
 */
public class FTPTest {
    public static void main(String[] args) throws FileNotFoundException {
        OaFtp oaFtp=new OaFtp();
        oaFtp.setIp("127.0.0.1");
        oaFtp.setPort("9001");
        oaFtp.setName("ftp");
        oaFtp.setPwd("123456");

        FileInputStream fileInputStream = new FileInputStream("C:\\Users\\Administrator\\Desktop\\cell.xlsx");

        FTPUtil.upload(oaFtp,"cell.xlsx","C:\\Users\\Administrator\\Desktop",fileInputStream);
    }
}
