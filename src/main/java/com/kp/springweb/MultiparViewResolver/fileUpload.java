package com.kp.springweb.MultiparViewResolver;

//文件上传
// 1添加依赖2表单3添加快捷控制器

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

@Controller
public class fileUpload {

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    @ResponseBody
    public Object upload(MultipartFile file) {
        try {
            /*处理上传文件*/
            String filePath = "C:\\AMD\\";
            File de = new File(filePath + file.getOriginalFilename().getBytes("ISO-8859-1"), "UTF-8");
            File destFile = new File(new String(file.getOriginalFilename().getBytes("ISO-8859-1"), "UTF-8"));
            System.out.println(de.getAbsolutePath());
            System.out.println(destFile.getAbsolutePath());
            FileUtils.writeByteArrayToFile(de, file.getBytes());
            //FileUtils.writeByteArrayToFile(destFile,file.getBytes());//文件保存
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "success";
    }
}
