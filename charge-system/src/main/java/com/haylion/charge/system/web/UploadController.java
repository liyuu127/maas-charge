package com.haylion.charge.system.web;


import com.haylion.common.core.model.ResponseData;
import com.haylion.charge.system.model.form.FileDeleteForm;
import com.haylion.charge.system.service.UploadService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * @description: 上传接口
 * @create: 2020-06-11 11:36
 **/
@Slf4j
@RestController
@RequestMapping("/file")
public class UploadController {

    @Autowired
    UploadService uploadService;


    /**
     * 上传文件
     *
     * @param file
     * @return
     * @throws Exception
     */
    @PostMapping("/upload")
    public ResponseData upload(MultipartFile file) throws IOException {
        return uploadService.upload(file);

    }

    /**
     * 根据文件路径删除文件
     *
     * @return
     */
    @PostMapping("/delete")
    public ResponseData delete(@RequestBody FileDeleteForm fileDeleteForm) {
        return uploadService.delete(fileDeleteForm.getFileUrl());
    }

}
