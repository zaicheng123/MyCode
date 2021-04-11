package cn.jbit.utils;

import cn.jbit.pojo.DemoData;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 源码学院只为培养优秀的bat程序员而生
 *
 * @author 学员张在成
 * @data 2020/10/17
 */
public class EasyExcelUtils {

    public  static  List<DemoData> data(){

        List<DemoData> demoDataList=new ArrayList<>();
        for (int i=0;i<10;i++){
            DemoData  demoData=new DemoData();
            demoData.setString("张杰："+i);
            demoData.setDate(new Date());
            demoData.setDoubleData(0.57);
            demoDataList.add(demoData);
        }
        return demoDataList;
    }
}
