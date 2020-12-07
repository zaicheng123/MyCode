package cn.jbit.reentrantlock;

import java.util.concurrent.locks.ReentrantLock;

public class MyReentrantLock03 extends Thread{

        private  static ReentrantLock lock=new ReentrantLock(true);

        public void run(){
            for (int i=1;i<10;i++){
                lock.lock();
                try {
                    System.out.println(Thread.currentThread().getName()+"获得锁");
                }catch(Exception e){
                    e.printStackTrace();
                }finally {
                    lock.unlock();
                }
            }
        }

    public static void main(String[] args) throws InterruptedException {
        MyReentrantLock03 lock03=new MyReentrantLock03();
        Thread t1=new Thread(lock03);
        Thread t2=new Thread(lock03);
        t1.start();
        t2.start();
        for (int i=1;i<=10;i++){
            if (i==4){
                t2.join();
            }
            if (i==8){
                t1.join();
            }
        }
    }



}
