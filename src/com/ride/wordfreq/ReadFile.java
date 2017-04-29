package com.ride.wordfreq;

import java.io.*;

/**
 * Created by ride on 17-4-27.
 * 文件读取类
 */
public class ReadFile {
    /**
     * 读取文件
     *
     * @param filename 文件名
     * @return 读取到的文件内容
     */
    public static String read(String filename) {
        StringBuffer sb = new StringBuffer();
        try {
            InputStreamReader isr = new InputStreamReader(new FileInputStream(filename));
            BufferedReader in = new BufferedReader(isr);
            try {
                String s;
                while ((s = in.readLine()) != null) {
                    sb.append(s);
                    sb.append('\n');
                }
            } finally {
                in.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return sb.toString();
    }

    /**
     * 读取文件
     *
     * @param filename 文件名
     * @param codeType 编码格式
     * @return 读取到的文件内容
     */
    public static String read(String filename, String codeType) {
        StringBuffer sb = new StringBuffer();
        try {
            InputStreamReader isr = new InputStreamReader(new FileInputStream(filename), codeType);
            BufferedReader in = new BufferedReader(isr);
            try {
                String s;
                while ((s = in.readLine()) != null) {
                    sb.append(s);
                    sb.append('\n');
                }
            } finally {
                in.close();
            }
        } catch (IOException e1) {
            e1.printStackTrace();
        }

        return sb.toString();
    }
}
