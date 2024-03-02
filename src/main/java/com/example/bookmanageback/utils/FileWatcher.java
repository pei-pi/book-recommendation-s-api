package com.example.bookmanageback.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.nio.file.*;

@Component
public class FileWatcher {

    @Autowired
    private ResourceLoader resourceLoader;

    @PostConstruct
    public void init() {
        try {
            WatchService watchService = FileSystems.getDefault().newWatchService();
            // 获取文件系统路径
            String filePath = resourceLoader.getResource("classpath:static/image").getFile().getAbsolutePath();
            Path path = Paths.get(filePath);
            System.out.println(path);
            path.register(watchService, StandardWatchEventKinds.ENTRY_CREATE, StandardWatchEventKinds.ENTRY_DELETE, StandardWatchEventKinds.ENTRY_MODIFY);

            Thread watchThread = new Thread(() -> {
                try {
                    WatchKey key;
                    while ((key = watchService.take()) != null) {
                        for (WatchEvent<?> event : key.pollEvents()) {
                            // 处理文件变化事件
                            System.out.println("Event kind:" + event.kind() + ". File affected: " + event.context() + ".");
                        }
                        key.reset();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
            watchThread.setDaemon(true);
            watchThread.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
