package com.ride.wordfreq;
import java.io.IOException;
import java.util.*;

/**
 * Created by ride on 17-4-27.
 * 运行
 */
public class MainClass {
    private final static String test1 = "txt/test1.txt";
    private final static String test2 = "txt/test2.txt";
    private final static String dict = "txt/2-2-3lem.txt";
    private final static String transDict = "txt/transDict.txt";
    private final static String freqTest = "txt/freqTest.txt";
    private final static String out2CSV = "txt/out.csv";
    private final static String out = "txt/out.txt";
    private final static String theOldManAndTheSea = "txt/the old man and the sea.txt";

    public static void main(String args[]) {
        /*System.out.print(ReadFile.read(test1));
        System.out.println(ReadFile.read(test2, "utf-8"));*/
        HashMap<String, String> dictMap = Dict.readDict(test1);
        String inPut = ReadFile.read(theOldManAndTheSea);
        HashMap<String, Integer> freqMap = ParseFile.getFreq(inPut, dictMap);
        Map<String, Integer> sortMap;
        try {
            sortMap = SortMap.sortMap(freqMap);
            int i = 0;
            for (Map.Entry<String, Integer> entry : sortMap.entrySet()) {
                i++;
                System.out.println("key=" + entry.getKey() + ", value=" + entry.getValue());
                if (i > 20) {
                    break;
                }
            }
            OutPut.write2CSV(sortMap, out2CSV);
            OutPut.write(sortMap, out, transDict);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
