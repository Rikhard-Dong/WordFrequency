package com.ride.wordfreq;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by ride on 17-4-27.
 * 读入英汉字典
 */
public class TransDict {
    /**
     * 读取英汉字典
     * @param filename  文件路径+文件名
     * @param codeType  文件编码格式
     * @return  key-英文, value-中文翻译
     */
    public static HashMap<String, String> transDict(String filename, String codeType) {
        String dict = ReadFile.read(filename, codeType);
        HashMap<String, String> transDictMap = new HashMap<>();
        ArrayList<String> arrayList = new ArrayList<>();
        Pattern pattern = Pattern.compile("^(.+)\\s{6}(.+)");
        Scanner scanner = new Scanner(dict);
        while (scanner.hasNext()) {
            arrayList.add(scanner.nextLine());
        }
        for (String string : arrayList) {
            Matcher matcher = pattern.matcher(string);
            if (matcher.find()) {
                transDictMap.put(matcher.group(1), matcher.group(2));
            }
        }
        scanner.close();
        return transDictMap;
    }
}
