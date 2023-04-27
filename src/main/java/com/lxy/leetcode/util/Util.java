package com.lxy.leetcode.util;

import java.util.concurrent.ThreadLocalRandom;

public class Util {
    public static String toSimpleString(Object o) {
        return o.getClass().getSimpleName() + "@" + Integer.toHexString(o.hashCode());
    }

    public static int randomInt(int min, int max) {
        return ThreadLocalRandom.current().nextInt(min, max);
    }

    public static int randomIntClosed(int min, int max) {
        return randomInt(min, max + 1);
    }

    public static int randomInt(int max) {
        return randomInt(0, max);
    }

    public static int randomIntClosed(int max) {
        return randomInt(max + 1);
    }
}
