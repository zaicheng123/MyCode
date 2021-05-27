package cn.jbit.volatil;

public class Test_ThreadVisibility {

    private  /*volatile*/ boolean  flag=false;

    public void  refresh(){
        this.flag=true;
        System.out.println(Thread.currentThread().getName()+"修改flag");
    }

    public  void  load() throws InterruptedException {
        while (!flag){
            Thread.sleep(1000);
            //shortWait(100000);
        }
        System.out.println(Thread.currentThread().getName()+"跳出循环，flag："+flag);
    }

    public  void  shortWait(long interval){
        long start=System.nanoTime();
        long end;
        do {
            end=System.nanoTime();
        }while (start+interval>=end);

    }

    public static void main(String[] args) throws InterruptedException {

                Test_ThreadVisibility  visibility=new Test_ThreadVisibility();
                new Thread(()-> {
                    try {
                        visibility.load();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                },"threadA").start();

                Thread.sleep(2000);
                new Thread(()->visibility.refresh(),"threadB").start();
    }
}
