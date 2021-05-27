package cn.jbit.javareference;

import java.lang.ref.WeakReference;

public class Weak {

  public static void main(String[] args) {

       WeakReference<Strong>  weak=new WeakReference<>(new Strong());

       System.out.println(weak.get());

       System.gc();

       System.out.println(weak.get());

       ThreadLocal<Strong>  tl=new ThreadLocal<>();

       tl.set(new Strong());

       tl.remove();

  }
}
