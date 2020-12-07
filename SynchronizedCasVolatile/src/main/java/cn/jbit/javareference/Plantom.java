package cn.jbit.javareference;

import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.util.LinkedList;
import java.util.List;
/**
 *虚引用
 *
 * */
public class Plantom {
    //创建一个List集合，模拟内存溢出
    private  static final List<Object>  list=new LinkedList<>();
    //虚引用里面需设置两个值，一个new出来的强引用对象，另外一个就是引用队列
    private  static  final ReferenceQueue<M> QUEUE=new ReferenceQueue<>();

  public static void main(String[] args) throws InterruptedException {

      PhantomReference<M> phantomReference=new PhantomReference<>(new M(),QUEUE);
      new Thread(()->{
          while (true){
              list.add(new byte[1024*1024]);
              try {
                  Thread.sleep(1000);
              } catch (InterruptedException e) {
                  e.printStackTrace();
                  Thread.currentThread().interrupt();
              }
              System.out.println(phantomReference.get());
          }
      }).start();


      new Thread(()->{
          while(true){
              Reference<? extends M> poll=QUEUE.poll();
              if (poll!=null){
                  System.out.println("虚引用对象被jvm虚拟机回收了----"+poll);
              }
          }
      }).start();
      Thread.sleep(500);
   }
}
