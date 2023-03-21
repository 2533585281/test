package com.wzb.test.Thread;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.thread.ThreadUtil;
import lombok.SneakyThrows;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.*;

/**
 * @Author Administrator
 * @Date 2022/8/30 0030 16:17
 */
public class MyThread implements Runnable{
    private int ticket = 5 ;    // 假设一共有5张票
    @Override
    public void run(){
        for(int i=0;i<100;i++){
            synchronized(this){ // 要对当前对象进行同步
                if(ticket>0){   // 还有票
                    try{
                        Thread.sleep(300) ; // 加入延迟
                    }catch(InterruptedException e){
                        e.printStackTrace() ;
                    }
                    System.out.println(Thread.currentThread().getName()+"卖票：ticket = " + ticket-- );
                }
            }
        }
    }
};
class SyncDemo02{
    public static void main(String args[]){
        // 线程
//        MyThread mt = new MyThread() ;  // 定义线程对象
//        Thread t1 = new Thread(mt,"线程1") ;    // 定义Thread对象
//        Thread t2 = new Thread(mt,"线程2") ;    // 定义Thread对象
//        Thread t3 = new Thread(mt,"线程3") ;    // 定义Thread对象
//        t1.start() ;
//        t2.start() ;
//        t3.start() ;


        // 线程池
        List<String> list=new ArrayList<>();
        for (int i = 0; i < 20 ; i++) {
            list.add("s"+i);
        }
        Iterator<String> iterator = list.iterator();

        ExecutorService service = new ThreadPoolExecutor(5, 5,
                                 1, TimeUnit.MINUTES, new ArrayBlockingQueue<>(list.size(), false),
                                Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy());
//        while (iterator.hasNext()){
//            String next=iterator.next();
//            service.execute(new Runnable() {
//                @SneakyThrows
//                @Override
//                public void run() {
//                    System.out.println(DateUtil.format(new Date(),"yyyy-MM-dd HH:mm:ss")+": 线程："+Thread.currentThread().getName()+",输出："+next);
//                    Thread.sleep(2000);
//                }
//            });
//        }
//        service.shutdown();

        // hutool线程池
        ExecutorService hutoolService = ThreadUtil.newExecutor(5,5,list.size());
        while (iterator.hasNext()){
            String next=iterator.next();
            hutoolService.execute(new Runnable() {
                @SneakyThrows
                @Override
                public void run() {
                    System.out.println(DateUtil.format(new Date(),"yyyy-MM-dd HH:mm:ss")+": 线程："+Thread.currentThread().getName()+",输出："+next);
                    Thread.sleep(2000);
                }
            });
        }
        hutoolService.shutdown();
    }


};
