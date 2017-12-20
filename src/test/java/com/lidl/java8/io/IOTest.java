package com.lidl.java8.io;

import com.sun.org.apache.regexp.internal.RE;
import com.sun.org.apache.xpath.internal.SourceTree;
import org.junit.Test;

import java.io.*;
import java.util.Optional;
import java.util.Random;
import java.util.stream.IntStream;

/**
 * 描述:
 *
 * @author lidongliang
 * @create 2017-11-29 10:01
 */
public class IOTest {

    @Test
    public void givenUsingPlainJava_whenConvertingInputStreamIntoReader_thenCorrect()
            throws IOException {
        InputStream initialStream = new ByteArrayInputStream("With Java".getBytes());

        Reader targetReader = new InputStreamReader(initialStream);

//        System.out.println("targetReader = " + targetReader.read());

        targetReader.close();

//        String abc = null;
        String abc = "asdasd";
        Optional<String> name = Optional.ofNullable(abc);

        System.out.println(name.orElse("tony"));
        if (name.isPresent()) {
            //在Optional实例内调用get()返回已存在的值
            System.out.println(name.get());//输出Sanaulla
        }

//        String value = name.flatMap(val -> Optional.of(val.toUpperCase()));
        Optional<String> values = name.flatMap((value) -> Optional.of(value.toUpperCase()));
        System.out.println(values.orElse("no value find!"));


        Random random = new Random();
        IntStream intStream = random.ints(0, 100);
        intStream.limit(10).forEach(System.out::println);
    }

    @Test
    public void random() {
        Random random = new Random();
        IntStream intStream = random.ints(0, 100);
        intStream.limit(10).forEach(System.out::println);
    }

}
