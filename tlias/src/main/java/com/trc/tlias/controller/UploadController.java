package com.trc.tlias.controller;

import com.trc.tlias.pojo.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Slf4j
@RestController
public class UploadController {
    @PostMapping("/upload")
//            姓名: <input type="text" name="username"><br>
//        年龄: <input type="text" name="age"><br>
//        头像: <input type="file" name="image"><br>
    public Result UploadFuncion(String username, Integer age, MultipartFile image) throws IOException {
        log.info("文件上传{}，{}，{}",username,age,image);

        String originalFilename = image.getOriginalFilename();
        int index = originalFilename.lastIndexOf(".");
        String substring = originalFilename.substring(index);
        String newfileName = UUID.randomUUID().toString()+substring;
        image.transferTo(new File("C:\\office_use\\CacheDatas\\"+newfileName));
        return Result.success("C:\\office_use\\CacheDatas\\"+newfileName);
    }
}
