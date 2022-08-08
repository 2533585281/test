package com.wzb.game;

/**
 * @Author Administrator
 * @Date 2022/5/10 0010 16:17
 */
import javax.swing.*;
import java.awt.*;

public class AllGraph extends JFrame {
    private final int OVAL_WIDTH =80;                                    //圆形的宽
    private final int OVAL_HELGHT =80;                                   //圆形的高

    public AllGraph(){
        //调用初始化方法
        initialize();

    }

    //初始化方法
    private void initialize() {
        setSize(520,400);                                     //设置窗体大小
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);                    //设置窗体关闭模式
        setContentPane(new DrawPanel());                                  //设置窗体面板为绘图面板对象
        setTitle("绘图实例2");                                               //设置窗体标题
    }

    //创建绘制面板
    class DrawPanel extends JPanel{
        //重写绘制方法
        public void paint(Graphics g){
            //圆形
            g.drawOval(10,10,OVAL_WIDTH,OVAL_HELGHT);
            //弧形
            g.drawArc(100,10,OVAL_HELGHT,OVAL_HELGHT,270,200);
            //直线
            g.drawLine(200,30,280,30);
            g.drawLine(200,60,280,60);
            //多边形
            int[] xs={300,300,380,380};
            int[] ys={10,80,10,80};
            g.drawPolygon(xs,ys,4);
            //多变线
            int[] xs1={400,400,480,480};
            int[] ys1={10,80,10,80};
            g.drawPolyline(xs1,ys1,4);
            //矩形
            g.drawRect(10,100,OVAL_WIDTH,OVAL_HELGHT);
            //圆角矩形
            g.drawRoundRect(100,100,OVAL_WIDTH,OVAL_HELGHT,50,50);
            //实心椭圆
            g.fillOval(200,100,OVAL_WIDTH,OVAL_HELGHT);
            //实心弧形
            g.fillArc(300,100,OVAL_WIDTH,OVAL_HELGHT,270,200);
            int[] xs2={400,400,480,480};
            int[] ys2={110,180,110,180};
            g.fillPolygon(xs2,ys2,4);
            //实心矩形
            g.fillRect(10,200,OVAL_WIDTH,OVAL_HELGHT);
            //实心圆角矩形
            g.fillRoundRect(100,200,OVAL_WIDTH,OVAL_WIDTH,50,50);


        }
    }

    public static void main(String[] args) {
        new AllGraph().setVisible(true);
    }
}