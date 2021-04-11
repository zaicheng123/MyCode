package cn.jbit.synchronize;

/**
 * 锁消除
 */
public class Lockeliminate {

    public  void  add(String s1,String s2){
            //StringBuffer本身就是线程安全的，因为它的大多数方法是被synchronized修饰的
            StringBuffer  sb=new StringBuffer();
            sb.append(s1).append(s2);
    }
}
