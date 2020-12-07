package cn.jbit.volatil;

/**
 * volatile可以防止指令重排序
 */
public class DisordeAction {
        //乱序执行出现的可能结果
        private static volatile int x=0,y=0;
        private static volatile   int a=0,b=0;

        public static void main(String[] args) throws InterruptedException {
            int i=0;
            for (;;){
                i++;
                x=0;y=0;
                a=0;b=0;
                Thread t1=new Thread(new Runnable() {
                    @Override
                    public void run() {
                        shortWait(100000);
                            a=1;
                            x=b;
                    }
                });

                Thread t2=new Thread(new Runnable() {
                    @Override
                    public void run() {
                            b=1;
                            y=a;
                    }
                });
                t1.start();t2.start();
                t1.join();t2.join();
                String result="第"+i+"次"+"("+x+","+y+")";
                System.out.println(result);
                if (x==0&&y==0){
                  System.err.println(result);
                  break;
                }else {

                }
            }
        }

        public  static void shortWait(long interval){
            long start=System.nanoTime();
            long end;
            do{
                end=System.nanoTime();
            }while (start+interval>=end);
        }
}
