package cn.jbit.pojo;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

import java.util.Date;

/**
 * 源码学院只为培养优秀的bat程序员而生
 *
 * @author 学员张在成
 * @data 2020/10/17
 */
@Data
public class DemoData {

    @ExcelProperty(value = "字符串标题")
    private  String string;

    @ExcelProperty(value = "日期标题")
    private Date date;

    @ExcelProperty(value = "数字标题")
    private  Double doubleData;

    //最高版本的依赖才有这个注解，意思是忽略这个字段
    @ExcelIgnore
    private  String ignore;






}
