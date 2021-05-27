package cn.jbit.reentrantlock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MyReentrantLock {
        Lock lock=new ReentrantLock();

        public  void  m(){
            try {
                lock.lock();
                for (int i=0;i<10;i++){
                    TimeUnit.SECONDS.sleep(1);
                    System.out.println("m："+i);
                }
            }catch (InterruptedException e){
                e.printStackTrace();
            }finally {
                lock.unlock();
            }
        }

        public void n(){
            try {
                lock.lock();
                for (int i=0;i<10;i++){
                    TimeUnit.SECONDS.sleep(100);
                    System.out.println("n:"+i);
                }
            }catch (InterruptedException e){
                e.printStackTrace();;
            }finally {
                lock.unlock();
            }
        }



        public static void main(String[] args) throws InterruptedException {
            MyReentrantLock myReentrantLock=new MyReentrantLock();
            new Thread(myReentrantLock::m).start();
            TimeUnit.SECONDS.sleep(1);
            new Thread(myReentrantLock::n).start();
        }
}
