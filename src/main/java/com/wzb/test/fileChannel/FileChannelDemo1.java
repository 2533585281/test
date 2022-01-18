package com.wzb.test.fileChannel;

import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @Author Administrator
 * @Date 2021/12/29 0029 15:27
 */
public class FileChannelDemo1 {

    /**
     *  FileChannel读取数据到Buffer(缓冲区)
     * @param args
     */
    public static void main(String[] args) throws Exception {
        // 创建FileChannel通道
        RandomAccessFile aFile=new RandomAccessFile("C:\\Users\\Administrator\\Desktop\\新建文本文档.txt","rw");
        FileChannel channel = aFile.getChannel();
        // 创建buffer缓冲区
        ByteBuffer buf = ByteBuffer.allocate(1024);

        // 读取数据到Buffer(缓冲区)
        int bytesRead = channel.read(buf);
        while (bytesRead!=-1){
            System.out.println("读取了："+bytesRead);
            buf.flip();
            while (buf.hasRemaining()){
                System.out.println((char) buf.get());
            }
            buf.clear();
            bytesRead=channel.read(buf);
        }
        aFile.close();
        System.out.println("操作结束了！");

    }
}
