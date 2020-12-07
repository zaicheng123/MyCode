package cn.jbit.synchronize;

/**
 * 锁粗化
 */
public class LockCoarse {

        public  String  test(String s1){
            int i=0;
            StringBuffer sb=new StringBuffer();
            while(true){
                sb.append(s1);
                i++;
            }

        }

}
