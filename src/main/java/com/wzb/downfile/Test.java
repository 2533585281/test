package com.wzb.downfile;

/**
 * @Author Administrator
 * @Date 2021/11/9 0009
 */
public class Test {
    public static void main(String[] args) {
        //服务器IP
        String  dataServerIp ="47.94.158.209";
        //服务器用户名
        String  dataServerUsername ="root" ;
        //服务器登录密码
        String  dataServerPassword ="Pengbo121831";
        //要下载的文件路径
        String  srcFile ="/root/2.xlsx";
        //保存路径
        String  saveFile="C:/test";
        //端口号，null时为默认端口
        int   port= 22;
        Down.downLoadFile(dataServerIp,dataServerUsername,dataServerPassword,srcFile,saveFile,port);
    }

}
