package com.example.bookmanageback.controller;

import com.example.bookmanageback.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.util.StringUtils;
import org.apache.commons.io.FilenameUtils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

@RestController
public class ImageController {
    private static final String UPLOAD_DIR = "static/image";

    @Autowired
    private ResourceLoader resourceLoader;

    @PostMapping("/upload/image")
    public Result uploadImage(@RequestParam("image") MultipartFile imageFile) {
        try {
            // 检查文件是否为空
            if (imageFile.isEmpty()) {
                return Result.error().data("message", "上传失败，请选择文件");
            }

            // 获取文件名
            String fileName = StringUtils.cleanPath(imageFile.getOriginalFilename());

            // 获取文件保存路径
            Path uploadPath = Paths.get(resourceLoader.getResource("classpath:" + UPLOAD_DIR).getFile().getAbsolutePath());

            // 如果目录不存在，则创建目录
            if (!Files.exists(uploadPath)) {
                Files.createDirectories(uploadPath);
            }

            // 检查文件名是否存在冲突，如果存在冲突则修改文件名
            if (Files.exists(uploadPath.resolve(fileName))) {
                String baseName = FilenameUtils.getBaseName(fileName);
                String extension = FilenameUtils.getExtension(fileName);
                fileName = baseName + "_" + UUID.randomUUID().toString() + "." + extension;
            }

            // 写入文件到目标位置
            Files.copy(imageFile.getInputStream(), uploadPath.resolve(fileName));

            return Result.ok().data("message", fileName);
        } catch (IOException e) {
            e.printStackTrace();
            return Result.error().data("message", "文件上传失败：" + e.getMessage());
        }
    }
}
