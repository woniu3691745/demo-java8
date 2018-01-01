package com.utils;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.util.FileCopyUtils;

import java.io.IOException;
import java.io.OutputStream;

/**
 * 文件工具类
 *
 * @author lidongliang
 * @create 2018-01-01 下午3:55
 **/
public class File {

    /**
     * 解析文件
     *
     * @param os
     * @throws IOException
     */
    public void FileMethonOne(OutputStream os) throws IOException {
        Resource resource = new ClassPathResource("/temp.img");
        FileCopyUtils.copy(resource.getInputStream(), os);
    }

    /**
     * 生成文件
     *
     * @throws IOException
     */
    public void FileMethodTwo() throws IOException {
        Resource resource = new FileSystemResource("c:/temp.img");
        FileCopyUtils.copy(new java.io.File(""), resource.getFile());

    }
}
