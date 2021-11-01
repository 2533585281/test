package com.wzb.test;

import com.wzb.entity.parent;
import com.wzb.entity.subclass;
import org.springframework.stereotype.Component;

/**
 * 定时任务  三个关键注解
 * @EnableScheduling // 开启定时任务，标注在启动类上
 * @Component        // 托管给spring，标注在类上
 * @Scheduled        // cron表达式定时，标注在方法上
 */

@Component
public class timedTask {
    /**
     * https://cron.qqe2.com/   在线Cron表达式生成器
     * 0 0 23 * * ? *   每天晚上11点执行
     * 0 0/5 * * * ? *  每5分钟执行一次
     */

    // 添加定时任务
  //  @Scheduled(cron = "0/5 * * * * ?") // cron 表达式，每五秒执行一次
    public  void doTask(){
        System.out.println("我是定时任务~");
    }

    public static void main(String[] args) {
//        Scanner sc=new Scanner(System.in);
//        int i=sc.nextInt();
//        if(i<3){
//            System.out.println("i<3");
//        }else if (i < 6){
//            System.out.println("i>=3&&i<6");
//        }else {
//            System.out.println("i>=6");
//        }

//        String[] str=new String[]{"1","2"};
//
//        System.out.println("for i 循环");
//        for (int j=0;j<str.length;j++) {
//            System.out.println(str[j]);
//        }
//        System.out.println("foreach 循环");
//        for (String s : str) {
//            System.out.println(s);
//        }

//        String s = "'sds gdasda" + "\n" + "edaeafd'";
//        System.out.println("转换前："+s);
//        s = s.replaceAll("\r|\n", "<br>");
//        System.out.println("转换后："+s);

        parent ab=new parent();
        subclass b=new subclass("彭博","20","上海","打不通");
        sout(b);
    }

    public static void sout(parent ab){
        subclass b=(subclass)ab;
        System.out.println(b.toString());
    }


}
