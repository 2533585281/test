package com.wzb.test.fileChannel;

import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;

/**
 * @Author Administrator
 * @Date 2021/12/29 0029 16:08
 * FileChannelDemo 通道之间数据的传输
 */

public class FileChannelDemo3 {
    // tuansferFrom()  tuansferFrom() 实现通道之间的数据传输
    public static void main(String[] args) throws Exception {
        // 创建两个通道
        RandomAccessFile aFile=new RandomAccessFile("C:\\Users\\Administrator\\Desktop\\1.txt","rw");
        FileChannel fromChannel = aFile.getChannel();

        RandomAccessFile bFile=new RandomAccessFile("C:\\Users\\Administrator\\Desktop\\2.txt","rw");
        FileChannel toChannel = bFile.getChannel();

        // fromChannel 传输到 toChannel,从第几位，传到第几位
        long position=0;
        long count=fromChannel.size();
        // 空文件获取文件数据
        toChannel.transferFrom(fromChannel,position,count);
        // 文件数据传到空文件
//        fromChannel.transferTo(position,count,toChannel);

        System.out.println("传输完成。。");

        aFile.close();
        bFile.close();


    }
}
