package cn.jbit.listener;

import cn.jbit.dao.DemoDataMapper;
import cn.jbit.pojo.DemoData;
import cn.jbit.service.UserService;
import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 * 源码学院只为培养优秀的bat程序员而生
 *
 * @author 学员张在成
 * @data 2020/10/17
 */
public class DemoDataListener extends AnalysisEventListener<DemoData> {

    private  static  final Logger logger= LoggerFactory.getLogger(DemoDataListener.class);

    /*
     * 每隔5条数据进行一次数据的存储，实际使用中可以3000条，然后清理list，方便内存回收
     */
    private  static  final  int  BATCH_COUNT=5;

    List<DemoData> list=new ArrayList<>();

    @Autowired
    private UserService userService;

    @Autowired
    private DemoDataMapper demoDataMapper;

    public DemoDataListener(DemoDataMapper demoDataMapper) {
        this.demoDataMapper=demoDataMapper;
    }

    @Override
    public void invoke(DemoData demoData, AnalysisContext analysisContext) {
            logger.info("解析到一条数据："+ JSON.toJSONString(demoData));
            System.out.println(JSON.toJSONString(demoData));
            list.add(demoData);
            if (list.size()>BATCH_COUNT){
                //保存数据
                saveDao();
                //存储完数据，清理list
                list.clear();
            }
    }

    //所有数据解析完毕，都会调用该方法
    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {
            //这里也要进行保存，确保遗留的数据也存入数据库
            saveDao();
            logger.info("所有数据解析完成...");
    }

    private   void  saveDao(){
            logger.info("{}条数据开始存储数据库!",list.size());
            int num=demoDataMapper.insertDemoData(list);
            logger.info("存储数据库成功!");
    }
}
