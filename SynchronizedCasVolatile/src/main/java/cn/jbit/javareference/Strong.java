package cn.jbit.javareference;

import java.io.IOException;

/**
 * ǿ���ã�ֻҪ��һ������ָ�������������ô����������һ�����������
 */
public class Strong {

    public static void main(String[] args) throws IOException {

        M m=new M();
        m=null;//������ʾΪ�գ����ǲ�����������ָ����������ˣ���m��new M()֮������ø������
        System.gc();
        System.in.read();

    }




}
