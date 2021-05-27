package cn.jbit.javareference;

import java.util.concurrent.TimeUnit;

public class ThreadLocal02 {

    private  static  ThreadLocal<Person> tl=new ThreadLocal<>();

    public static void main(String[] args) {

        new Thread(()->{
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(tl.get());
        }).start();


        new Thread(()->{
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            tl.set(new Person());
            System.out.println(tl.get());
        }).start();
    }
    static  class  Person{
        String name="zhangsan";
    }
}
