package com.wzb.test.fileChannel;

import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @Author Administrator
 * @Date 2021/12/29 0029 16:08
 * FileChannelDemo 写操作
 */

public class FileChannelDemo2 {

    public static void main(String[] args) throws Exception {
        // 打开FileChannel
        RandomAccessFile aFile=new RandomAccessFile("C:\\Users\\Administrator\\Desktop\\1.txt","rw");
        FileChannel channel = aFile.getChannel();

        // 创建buffer对象
        ByteBuffer buffer=ByteBuffer.allocate(1024);

        String s="FileChannel write ByteBuffer";
        buffer.clear();
        //写入文件
        buffer.put(s.getBytes());
        buffer.flip();
        //FileChannel 完成最终的实现
        while (buffer.hasRemaining()){
            channel.write(buffer);
        }
        // 关闭
        channel.close();

    }
}
