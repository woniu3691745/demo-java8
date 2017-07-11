package com.example.java8.io;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by lidongliang on 2017/7/10.
 * 读写文件
 */
public class Io01 {

    public void readFile () {
        File file = new File("D:\\PDF");
        String[] list = file.list();
        for (int i = 0; i < list.length; i++) {
            System.out.println(list[i]);
        }

        try {
            Path path = Paths.get("D:");
            Files.list(path).forEach(System.out::println);
            Files.readAllLines(path, StandardCharsets.UTF_8).forEach(System.out::print);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
