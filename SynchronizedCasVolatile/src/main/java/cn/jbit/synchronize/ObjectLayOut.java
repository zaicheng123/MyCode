package cn.jbit.synchronize;

import org.openjdk.jol.info.ClassLayout;

public class ObjectLayOut {

    public  synchronized  void  mm(Object o){
        System.out.println("你好:"+ClassLayout.parseInstance(o).toPrintable());
    }

  public static void main(String[] args) {

        Object o=new Object();
        System.out.println(ClassLayout.parseInstance(o).toPrintable());
        System.out.println(o.hashCode());
        /*synchronized (o){
           System.out.println(ClassLayout.parseInstance(o).toPrintable());
        }*/

        ObjectLayOut  layOut=new ObjectLayOut();
        layOut.mm(o);


  }
}
