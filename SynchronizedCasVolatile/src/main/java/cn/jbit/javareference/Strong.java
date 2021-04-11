package cn.jbit.javareference;

import java.io.IOException;

/**
 * 强引用，只要有一个引用指向了这个对象，那么垃圾回收器一定不会回收它
 */
public class Strong {

    public static void main(String[] args) throws IOException {

        M m=new M();
        m=null;//这里显示为空，就是不会再有引用指向这个对象了，把m和new M()之间的引用给打断了
        System.gc();
        System.in.read();

    }




}
