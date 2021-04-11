package cn.jbit.javareference;

public class M {
    @Override
    protected void finalize() throws Throwable {

        System.out.println("finalize");
    }


}
