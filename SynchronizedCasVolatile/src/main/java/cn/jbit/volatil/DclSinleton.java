package cn.jbit.volatil;

//双重校验锁
public class DclSinleton {

        private  static volatile DclSinleton dclSinleton;  //volatile防止了对象在初始化过程中的指令重排序
        private DclSinleton(){}

        public  static  DclSinleton  getInstance() throws InterruptedException {

            if (dclSinleton==null){
                synchronized (DclSinleton.class){
                    if (dclSinleton==null){
                        Thread.sleep(1);
                        dclSinleton=new DclSinleton();
                    }
                }
            }
            return dclSinleton;
        }


        public  void m(){
               System.out.println("m");
        }


        public static void main(String[] args) {
                for (int i=0;i<100;i++){
                    new Thread(()->{
                        try {
                            System.out.println(DclSinleton.getInstance().hashCode());
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }).start();
                }
        }
}
