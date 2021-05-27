package cn.jbit.exportdata;

import cn.hutool.core.date.DateTime;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 源码学院只为培养优秀的bat程序员而生
 *
 * @author 学员张在成
 * @data 2020/10/17
 *
 * SXSSF：是在XSSF基础上，POI3.8版本开始提供的支持低内存占用的操作方式，扩展名为.xlsx
 *
 */
public class Test_PoiExportData {

    public static void main(String[] args) throws IOException {
        String path="D:\\ES\\";
        //首先是创建一个工作簿,HSSFWorkbook的一个sheet的最大行数是65536，最大列数256
        Workbook workbook=new HSSFWorkbook();
        //XSSFWorkbook的一个sheet的最大行数是1048576，最大列数是16384
        //Workbook workbook1=new XSSFWorkbook();
        //创建一个sheet表
        Sheet sheet=workbook.createSheet("用户信息表");
        //创建行
        Row row=sheet.createRow(0);
        //创建列
        Cell cell=row.createCell(1);
        cell.setCellValue("用户名");
        //创建第二行
        Row row1=sheet.createRow(1);
        Cell cell1=row1.createCell(1);
        cell.setCellValue("密码");
        //创建第三行
        Row row2=sheet.createRow(2);
        Cell cell2=row2.createCell(2);
        String time=new DateTime().toString("yyyy-MM-dd");
        cell2.setCellValue(time);
        FileOutputStream fileOutputStream=new FileOutputStream(path+"用户信息表.xlsx");
        workbook.write(fileOutputStream);
        fileOutputStream.close();
        System.out.println("用户统计表已经生成");
    }
}
