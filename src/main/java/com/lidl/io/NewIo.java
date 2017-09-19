package com.lidl.io;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by lidongliang on 2017/7/10.
 * java8 读写文件
 */
public class NewIo {

    public void readFile() {
        File file = new File("D:\\PDF");
        String[] list = file.list();
        for (String aList : list) {
            System.out.println(aList);
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
