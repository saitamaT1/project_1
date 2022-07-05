package com.ultraneos.mall.util;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * @ClassName FileUploadUtils
 * @Description: TODO
 * @Author 远志 zhangsong@cskaoyan.onaliyun.com
 * @Date 2022/5/12 10:59
 * @Version V1.0
 **/
public class FileUploadUtils {

    public static Map<String, String> parseReqeuest(HttpServletRequest request){
        //采用了一种工厂设计模式
        DiskFileItemFactory factory = new DiskFileItemFactory();
        //下面三行代码表示的是如果上传的文件很大，会利用一个临时目录来充当缓存的位置
        //采用边缓存边上传的方式
        ServletContext servletContext = request.getServletContext();
        //每个应用在被加载到tomcat服务器中之后，tomcat会给每个应用设置生成一个临时目录，并且把该目录的位置放入每个应用对应的context域
        File repository = (File) servletContext.getAttribute("javax.servlet.context.tempdir");
        factory.setRepository(repository);
        //获取到处理文件上传业务逻辑的处理器
        ServletFileUpload upload = new ServletFileUpload(factory);
        Map<String, String> params = new HashMap<>();
        try {
            //每当页面有一个input提交，那么就会对应有一个FileItem
            List<FileItem> items = upload.parseRequest(request);
            for (FileItem item : items) {
                //item中有一个方法，可以判断是表单数据还是上传的文件
                if(!item.isFormField()){
                    processUploadFile(item, params, request);
                }
            }
        } catch (FileUploadException e) {
            e.printStackTrace();
        }
        return params;
    }


    /**
     * 该方法用来处理上传的文件逻辑
     * @param item
     * @param params
     * @param request
     */
    private static void processUploadFile(FileItem item, Map<String, String> params, HttpServletRequest request) {
        String fieldName = item.getFieldName();
        String fileName = item.getName();
        //对filename改名
        String uuid = UUID.randomUUID().toString();
        fileName = uuid + "-" + fileName;
        int hashCode = fileName.hashCode();
        String hexString = Integer.toHexString(hashCode);
        char[] chars = hexString.toCharArray();
        String basePath = "static/image";
        for (char aChar : chars) {
            basePath = basePath + "/" +aChar;
        }
        //希望将文件保存到应用根目录image目录下
        String relativePath = basePath + "/" + fileName;
        String realPath = request.getServletContext().getRealPath(relativePath);
        File file = new File(realPath);
        if(!file.getParentFile().exists()){
            file.getParentFile().mkdirs();
        }
        try {
            item.write(file);
            //需要将relativePath保存到对象中，进而后续保存到数据库中
            params.put(fieldName, relativePath);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
