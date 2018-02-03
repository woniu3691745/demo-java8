package io;

import java.io.*;

/**
 * ${DESCRIPTION}
 *
 * @author lidongliang
 * @create 2018-01-28 下午6:19
 **/
public class IOTest {

    public static void method01() {
        int b;
        System.out.println("Please Input: ");
        try {
            while ((b = System.in.read()) != -1) {
                System.out.print((char) b + " ");
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println(e.toString());
        }
    }

    public static void method02() {
        String s;
        // 创建缓冲区阅读器从键盘逐行读入数据
        InputStreamReader ir = new InputStreamReader(System.in);
        BufferedReader in = new BufferedReader(ir);
        try {
            // 读一行数据，并标准输出至显示器
            s = in.readLine();
            // readLine()方法运行时若发生I/O错误，将抛出IOException异常
            while (s != null) {
                System.out.println("Read: " + s);
                s = in.readLine();
            }
            // 关闭缓冲阅读器
            in.close();
        } catch (IOException e) { // Catch any IO exceptions.
            e.printStackTrace();
        }
    }

    public static void method03() {
        try {
            FileInputStream rf = new FileInputStream("/Users/lidongliang/project/JavaPro/123.txt");
            BufferedInputStream bis = new BufferedInputStream(rf);
            int n = 1024;
            byte[] buffer = new byte[n];
            while (bis.read(buffer, 0, n) != -1) {
                System.out.println(new String(buffer));
            }
            System.out.println();
            rf.close();
        } catch (IOException e) {
            System.out.println(e.toString());
        }

    }

    public static void method04(String filename) {
        BufferedReader in = null;
        StringBuilder sb = new StringBuilder();
        try {
            in = new BufferedReader(new FileReader(filename));
            String s;
            while ((s = in.readLine()) != null) {
                sb.append(s + "\n");
            }
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(sb.toString());
    }

    public static void main(String[] args) {
        IOTest.method04("/Users/lidongliang/project/JavaPro/123.txt");
    }
}
