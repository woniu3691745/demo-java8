package com.example.io;

import java.io.*;

/**
 * Created by lidongliang on 2017/7/28.
 *
 */
public class Demo {

    private OutputStream outputStream = null;
    private InputStream inputStream = null;

    private Writer writer = null;
    private Reader reader = null;

    private BufferedOutputStream bufferedOutputStream = null;
    private BufferedInputStream bufferedInputStream = null;


    private void outStream () {
        try {

            inputStream = new FileInputStream("e:\\FormImgView.jpg");
            outputStream = new FileOutputStream("e:\\FormImgView1.jpg");


            bufferedOutputStream = new BufferedOutputStream(
                                   new FileOutputStream("e:\\FormImgView.jpg"));
            bufferedInputStream = new BufferedInputStream(
                                  new FileInputStream("e:\\FormImgView1.jpg"));

            int i = 0;
            while(i != -1) {
                i = inputStream.read();
                outputStream.write(i);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (outputStream != null) {
                try {
                    inputStream.close();
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        Demo demo = new Demo();
        demo.outStream();
    }
}
