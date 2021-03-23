package com.inet.code.utils;

import com.inet.code.result.Result;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * FileUtils
 *
 * @author HCY
 * @since 2020/11/21 下午 06:42
 */
public class FileUtils {

    /**
    * 图片上传
    * @author HCY
    * @since 2020/11/22 下午 12:12
    */
    public static final String UPLOAD_REST_FILE_PATH = "/home/inet/softs/tomcat/apache-tomcat-9.0.44/webapps/bo-code-images/";

    public static final String REST_URL = "http://47.99.145.161:8080/bo-code-images/";

    /**
    * 上传文件
    * @author HCY
    * @since 2020/11/22 下午 12:13
    * @param file: 文件
    * @return java.lang.String
    */
    public static Result getUploading(MultipartFile file, String pathUrl) {
        //判断文件是否不存在
        if (file.isEmpty()){
            return new Result().result404("文件未找到",pathUrl);
        }
        //文件名
        String fileName = file.getOriginalFilename();
        //后缀名
        String suffixName = fileName.substring(fileName.lastIndexOf("."));
        //设置文件的上传位置
        String path = FileUtils.UPLOAD_REST_FILE_PATH;
        String url = FileUtils.REST_URL;
        //设置新的文件名字
        fileName = UUID.randomUUID().toString() + suffixName;
        File dest = new File(path + fileName);
        if (!dest.getParentFile().exists()) {
            dest.getParentFile().mkdirs();
        }
        //判断是否上传成功
        String network = null;
        try {
            //设置返回值
            Map<String, String> map = new HashMap<>(2);
            map.put("info","上传成功");
            file.transferTo(dest);
            network = url + fileName;
            map.put("url",network);
            return new Result().result200(map,pathUrl);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return new Result().result500("上传失败",pathUrl);
    }
}
