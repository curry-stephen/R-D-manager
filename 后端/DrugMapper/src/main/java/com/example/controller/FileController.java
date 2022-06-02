package com.example.controller;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.StrUtil;
import com.example.utils.Result;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.List;

@RestController
@RequestMapping("/files")
public class FileController {
    @Value("${server.port}")
    private String port;
    private static String ip="http://localhost:";

    @PostMapping("/upload")
    public Result uploadfile(MultipartFile file) throws IOException {
        String originalFilename = file.getOriginalFilename();
        String uuid = IdUtil.fastSimpleUUID();
        String path = System.getProperty("user.dir") + "\\src\\main\\resources\\files\\"+uuid+"_" + originalFilename;
        File file1 = FileUtil.writeBytes(file.getBytes(), path);
        System.out.println("端口："+port);
        return new Result(true,"上传成功",ip+port+"/files/"+originalFilename);
    }
    @GetMapping("/{flag}")
    public void getFiles(@PathVariable String flag, HttpServletResponse response){
        OutputStream os;//创建一个输出流对象
        String basePath = System.getProperty("user.dir") + "/src/main/resources/files/";
        List<String> list = FileUtil.listFileNames(basePath);//获取所有的文件名称
        String fileName = list.stream().filter(name -> name.contains(flag)).findAny().orElse("");//找到跟参数一致的文件
        try{
            if (StrUtil.isNotEmpty(fileName)){
                //System.out.println("文件名："+fileName);
                response.addHeader("Content-Disposition","attachment;filename="+ URLEncoder.encode(fileName,"UTF-8"));
                response.setContentType("application/octet-stream");
                byte[] bytes = FileUtil.readBytes(basePath + fileName);
                os=response.getOutputStream();
                os.write(bytes);
                os.flush();
                os.close();
            }
        }catch (Exception e){
            System.out.println("文件下载失败");
            e.printStackTrace();
        }
    }
}
