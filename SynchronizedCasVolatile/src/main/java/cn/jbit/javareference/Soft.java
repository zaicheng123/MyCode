package cn.jbit.javareference;

import java.lang.ref.SoftReference;

public class Soft {

  public static void main(String[] args) throws InterruptedException {

      SoftReference<byte[]> m=new SoftReference<>(new byte[1024*1024*10]);
      System.out.println(m.get());
      System.gc();
      Thread.sleep(1000);

      System.out.println(m.get());

      //再创建一个字节数组，开辟15M堆内存
      byte[] b=new byte[1024*1024*15];
      System.out.println(m.get());
  }
}
