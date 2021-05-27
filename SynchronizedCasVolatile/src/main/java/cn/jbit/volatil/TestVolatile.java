package cn.jbit.volatil;

import java.util.concurrent.TimeUnit;

public class TestVolatile {

      volatile boolean  running=true;//有无volatile的情况下，整个程序运行结果区别

        void m(){
         System.out.println("m,start");
         while (running){
         }
         System.out.println("n,end");
        }

         public static void main(String[] args) throws InterruptedException {

            TestVolatile  tvl=new TestVolatile();

            new Thread(tvl::m,"tvl1").start();

             TimeUnit.SECONDS.sleep(1);

             tvl.running=false;
        }
}
