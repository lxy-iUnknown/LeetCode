package com.lxy.leetcode.string;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/destination-city/">旅行终点站</a>
 */
public class DestinationCity {

    public static String destCity(List<List<String>> paths) {
        HashMap<String, String> pathMap = new HashMap<>(paths.size());
        for (List<String> path : paths) {
            pathMap.put(path.get(0), path.get(1));
        }
        for (String value : pathMap.values()) {
            if (!pathMap.containsKey(value)) {
                return value;
            }
        }
        // Should not reach here
        return null;
    }

    public static String destCityOptimized(List<List<String>> paths) {
        HashSet<String> sources = new HashSet<>(paths.size());
        for (List<String> path : paths) {
            sources.add(path.get(0));
        }
        for (List<String> path : paths) {
            String dest = path.get(1);
            if (!sources.contains(dest)) {
                return dest;
            }
        }
        // Should not reach here
        return null;
    }
}
