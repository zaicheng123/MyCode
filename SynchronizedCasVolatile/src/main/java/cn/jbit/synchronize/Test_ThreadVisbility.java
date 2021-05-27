package cn.jbit.synchronize;

public class Test_ThreadVisbility {

    private   boolean  flag=false;

    /**
     * 线程A修改变量
     */
    public  void  load() throws InterruptedException {
        System.out.println(Thread.currentThread().getName()+"修改变量");
        while (!flag){
            //Thread.sleep(1000);
            shortWait(1000);
        }
        System.out.println(Thread.currentThread().getName()+"跳出循环,flag:"+flag);
    }

    /**
     * 线程B修改变量
     */
    public  void  refreash(){
        flag=true;
        System.out.println(Thread.currentThread().getName()+"修改变量");
    }

    public  void  shortWait(long interval){
        long start=System.nanoTime();
        long end;
        do {
            end=System.nanoTime();
        }while (start+interval>=end);

    }



    public static void main(String[] args) throws InterruptedException {

            Test_ThreadVisbility  visbility=new Test_ThreadVisbility();

            new Thread(()->{
                try {
                    visbility.load();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            },"ThreadA").start();

            Thread.sleep(2000);

            new Thread(()->{
                visbility.refreash();
            },"ThreadB").start();

    }
}
