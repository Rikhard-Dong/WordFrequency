package com.ride.wordfreq;

import java.io.IOException;
import java.util.*;


/**
 * Created by ride on 17-4-27.
 * 对Map进行排序
 */
public class SortMap {
    /**
     * 对map进行排序
     *
     * @param map 待排序的map
     * @param <K> key
     * @param <V> value
     * @return 排序后的map
     * @throws IOException IO异常
     */
    public static <K, V extends Comparable<? super V>> Map<K, V> sortMap(Map<K, V> map) throws IOException {
        List<Map.Entry<K, V>> list = new LinkedList<>(map.entrySet());
        Collections.sort(list, (o1, o2) -> o2.getValue().compareTo(o1.getValue()));
        Map<K, V> result = new LinkedHashMap<>();
        for (Map.Entry<K, V> entry : list) {
            result.put(entry.getKey(), entry.getValue());
        }
        return result;
    }
}
