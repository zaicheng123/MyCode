package cn.jbit.controller;

import cn.jbit.utils.EasyExcelUtils;
import com.alibaba.excel.EasyExcel;
import com.alibaba.fastjson.JSON;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;


/**
 * 源码学院只为培养优秀的bat程序员而生
 *
 * @author 学员张在成
 * @data 2020/10/17
 */
@RestController
public class ExportDataController {

    @GetMapping("downloadFailedUsingJson")
    public  void  downloadFailJson(HttpServletResponse response) throws IOException {

        try {
            response.setContentType("application/vnd.ms-excel");
            response.setCharacterEncoding("UTF-8");
            String fileName= URLEncoder.encode("测试","UTF-8");
            response.setHeader("Content-disposition","attachment;filename="+fileName+".xlsx");

            //这里需要设置不关闭流
            EasyExcel.write(response.getOutputStream()).autoCloseStream(Boolean.FALSE).sheet("模板").doWrite(EasyExcelUtils.data());


        }catch (Exception e){
            //重置response
            response.reset();
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            Map<String,String> map=new HashMap<String, String>();
            map.put("status","failure");
            map.put("message","下载文件失败"+e.getMessage());
            response.getWriter().println(JSON.toJSONString(map));

        }

    }

    /*
     * 文件上传
     *
     *
     */

    @PostMapping(value = "upload")
    public  String upload(MultipartFile multipartFile) throws IOException {

        EasyExcel.read(multipartFile.getInputStream()).sheet().doRead();

        return "SUCCESS";
    }


}
