package cn.jbit.snowflake;

import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.net.NetUtil;
import cn.hutool.core.util.IdUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * 源码学院只为培养优秀的bat程序员而生
 *
 * @author 学员张在成
 * @data 2020/10/14
 * 测试雪花算法，分布式系统中生成唯一id一种解决方案，由19位的long型的有序数字组成，在MySQL数据库中采用bigint类型进行存储
 */
@Slf4j
@Component
public class Test_SnowFlake {

        //工作机器占位数
        private  long workerId=5;
        //数据中心占用位数
        private  long datacenterId=9;

        private  Snowflake snowflake= IdUtil.createSnowflake(workerId,datacenterId);

        /*
         *雪花算法初始化工作id
         */
        @PostConstruct
        public  void  init(){
                try {
                    workerId= NetUtil.ipv4ToLong(NetUtil.getLocalhostStr());
                    log.info("当前机器的workerId:{}",workerId);
                }catch (Exception e){
                    log.info("当前机器的workerId获取失败",e);
                    workerId=NetUtil.getLocalhostStr().hashCode();
                    log.info("当前机器的workerId:{}",workerId);
                }
        }

        //利用Snowflake算法程序生成19位的全局唯一自增id
        public synchronized long snowflakeId(){
                return snowflake.nextId();
        }

        public synchronized long snowflakeId(long workerId,long datacenterId){
            snowflake=IdUtil.createSnowflake(workerId,datacenterId);
            return snowflake.nextId();
        }

        public static void main(String[] args) {
            //测试生成一百万个雪花id所需的时间，8s
            long start=System.currentTimeMillis();
            for (int i=0;i<1000000;i++) {
                System.out.println(new Test_SnowFlake().snowflakeId());
            }
            System.out.println(System.currentTimeMillis()-start);

        }

}
