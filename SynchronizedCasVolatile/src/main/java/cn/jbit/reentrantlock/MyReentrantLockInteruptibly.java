package cn.jbit.reentrantlock;

import java.sql.Time;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MyReentrantLockInteruptibly {

    public static void main(String[] args){

        Lock  lock=new ReentrantLock();
            //t1线程
            Thread t1 = new Thread(() -> {
                    //try~lock加锁
                    try{
                        lock.lock();
                        System.out.println("t1 start");
                        TimeUnit.SECONDS.sleep(5);
                        System.out.println("t1 end");
                    }catch(InterruptedException e){
                        System.out.println("interrupted");
                    }finally {
                         lock.unlock();
                    }
            });
            t1.start();

            //t2线程
            Thread t2=new Thread(()->{
                //可以对interrupt()方法做出响应
                try {
                    lock.unlock();
                    //lock.lockInterruptibly();
                    System.out.println("t2 start");
                    TimeUnit.SECONDS.sleep(5);
                    System.out.println("t2 end");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    lock.unlock();
                }
            });
            t2.start();

            try {
                //睡眠一秒钟
                TimeUnit.SECONDS.sleep(1);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            //打断线程2的等待
            //t2.interrupt();
    }
}
