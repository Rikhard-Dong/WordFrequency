package com.ride.wordfreq;

import java.util.HashMap;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * Created by ride on 17-4-27.
 * 读入文件解析
 */
public class ParseFile {
    /**
     * 解析找出单词
     *
     * @param input   解析的字符串
     * @param dictMap 单词变种
     * @return key=单词, value=单词出现的次数
     */
    public static HashMap<String, Integer> getFreq(String input, HashMap<String, String> dictMap) {
        HashMap<String, Integer> freqMap = new HashMap<>();
        Pattern regex1 = Pattern.compile("(\\d|\\r|\\n)");          // 替换数字换行符
        Pattern regex2 = Pattern.compile("(\\p{Punct}|\\s){2,}");   // 去掉符号
        Pattern regex3 = Pattern.compile("(\\w+)'\\w+");            // 去掉上撇号
        input = regex1.matcher(input).replaceAll(" ");
        input = regex2.matcher(input).replaceAll(" ");
        input = regex3.matcher(input).replaceAll("$1");
        input = input.toLowerCase();
        Scanner scanner = new Scanner(input);

        while (scanner.hasNext()) {
            String s = scanner.next();
            if (dictMap.containsKey(s)) {
                s = dictMap.get(s);
            }
            if (s.length() > 1 || s.equals("a") || s.equals("I") || s.matches("(\\w|.|-)+")) {
                Integer freq = freqMap.get(s);
                freqMap.put(s, freq == null ? 1 : freq + 1);
            }
        }

        scanner.close();

        return freqMap;
    }
}
