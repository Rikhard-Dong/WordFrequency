package com.ride.wordfreq;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by ride on 17-4-27.
 * 将结果输出到文件
 */
public class OutPut {
    /**
     * 将结果概要输出到csv文件
     * @param map   词频结果
     * @param filename  文件名
     * @throws IOException  IO异常
     */
    public static void write2CSV(Map<String, Integer> map, String filename) throws IOException {
        FileWriter out = new FileWriter(filename);
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            out.write(entry.getKey() + "," + entry.getValue());
            out.write("\n");
        }
        out.flush();
        out.close();
    }

    /**
     * 将结果详细输出到txt文件中
     * @param map   词频结果
     * @param filename  文件名
     * @param transDict 字典文件名
     * @throws IOException  IO异常
     */
    public static void write(Map<String, Integer> map, String filename, String transDict) throws IOException {
        HashMap<String, String> transDictMap = TransDict.transDict(transDict, "utf-8");
        FileWriter out = new FileWriter(filename);
        int wordCount = 0;
        for (String string : map.keySet()) {
            wordCount += map.get(string);
        }
        out.write("总字数:" + wordCount + ", 共" + map.size() + "个单词\n");
        String title1 = String.format("%4s  %-14s %6s %5s   %-20s\n", "序号", "单词", "次数", "万分比", "翻译");
        String title2 = String.format("%6s  %-16s %8s %8s   %-20s\n", "----", "----", "----", "----", "----");
        out.write(title1);
        out.write(title2);
        int i = 0;
        String fm;
        String trans;
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            i++;
            String key = entry.getKey();
            int count = entry.getValue();
            if (transDictMap.containsKey(key)) {
                trans = transDictMap.get(key);
            } else {
                trans = "";
                key = key.toLowerCase();
            }
            fm = String.format("%6d  %-16.16s %8d %8.8s   %-20.35s \n",
                    i, key, count, (10000) * count / wordCount, trans);
            out.write(fm);
        }
        out.flush();
        out.close();
    }
}
