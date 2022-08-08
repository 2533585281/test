package com.wzb.game;

/**
 * @Author Administrator
 * @Date 2022/5/10 0010 16:28
 */
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;

public class ImgTest {

    public static void main(String[] args) throws IOException {
        // 读取本地图片文件
        // File file = new File("E:/imgs/test.png");
        // System.out.println("图片名称：" + file.getName());
        // System.out.println("图片大小：" + file.length() / 1024 + " kb");
        // 将文件对象转化为图片对象
        // BufferedImage image = ImageIO.read(file);
        // 获取网络图片
        URL url = new URL("https://zyq2022.oss-cn-chengdu.aliyuncs.com/test.png");
        BufferedImage image = ImageIO.read(url.openStream());
        // 创建画笔
        Graphics2D pen = image.createGraphics();
        // 设置画笔颜色为白色
        // pen.setColor(Color.WHITE);
        pen.setColor(new Color(179, 250, 233, 200));
        // 设置画笔字体样式为微软雅黑，斜体，文字大小为20px
        pen.setFont(new Font("微软雅黑", Font.ITALIC, 20));
        // 写上水印文字和坐标
        pen.drawString("我是图片水印", 30, 550);
        // 创建新图片文件
        File file = new File("E:/imgs/test2.png");
        // 将处理好的图片数据写入到新图片文件中
        FileOutputStream fos = new FileOutputStream(file);
        ImageIO.write(image, "png", fos);
    }
}