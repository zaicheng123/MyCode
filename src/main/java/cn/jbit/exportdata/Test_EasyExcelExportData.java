package cn.jbit.exportdata;

import cn.jbit.dao.DemoDataMapper;
import cn.jbit.listener.DemoDataListener;
import cn.jbit.pojo.DemoData;
import cn.jbit.utils.EasyExcelUtils;
import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.write.metadata.WriteSheet;


import java.util.List;

/**
 * 源码学院只为培养优秀的bat程序员而生
 *
 * @author 学员张在成
 * @data 2020/10/17
 */
public class Test_EasyExcelExportData {

    static String path="D:\\ES\\";
    static String fileName=path+"EasyExcel.xlsx";

    public static void simpleData() {
        //写法一
        //EasyExcel.write(fileName, DemoData.class).sheet("模板").doWrite(EasyExcelUtils.data());
        //写法二
        //文件名称
        String fileName1=path+"simpleWrite"+System.currentTimeMillis()+".xlsx";
        ExcelWriter excelWriter=null;
        //这里制定用哪个class去写
        try {
            excelWriter=EasyExcel.write(fileName1,DemoData.class).build();
            WriteSheet writeSheet=EasyExcel.writerSheet("模板").build();
            excelWriter.write(EasyExcelUtils.data(),writeSheet);
        }catch (Exception e){
                e.printStackTrace();
        }finally {
            //使用finish方法完成流的关闭
            excelWriter.finish();
        }
    }

    //重复多次写
    public static void  repeatableWrite(){

        fileName=path+"repeatableWrite"+System.currentTimeMillis()+".xlsx";

        ExcelWriter excelWriter=EasyExcel.write(fileName,DemoData.class).build();

        WriteSheet writeSheet=EasyExcel.writerSheet("模板").build();
        //实际根据数据库的总页数来分
        for (int i=0;i<5;i++){
            List<DemoData> demoDataList=EasyExcelUtils.data();
            excelWriter.write(demoDataList,writeSheet);
        }
        //关闭流
        excelWriter.finish();
    }

    //读取数据
    public  void  simpleRead(DemoDataMapper demoDataMapper){

        String fileName=path+"EasyTest.xlsx";

        EasyExcel.read(fileName,DemoData.class,new DemoDataListener(demoDataMapper)).sheet().doRead();
    }

    public static void main(String[] args) {

        simpleData();
        //repeatableWrite();
    }
}
