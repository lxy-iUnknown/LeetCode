package com.lxy.leetcode.string;

import java.util.ArrayList;
import java.util.Arrays;

public class ReorderSpaces {
    private static int splitAndCountSpaces(String text, ArrayList<Range> result) {
        var start = 0;
        var end = 0;
        var count = 0;
        while (true) {
            end = text.indexOf(' ', start);
            if (end < 0) {
                var length = text.length();
                if (length != start) {
                    // 最后一个空格已经处理完，只可能是最后一个单词
                    result.add(new Range(start, length));
                }
                break;
            }
            if (end == start) {
                // 空格数目加一
                count++;
                // end指向已处理的空格位置，跳到下一个字符
                start = end + 1;
            } else {
                result.add(new Range(start, end));
                // end指向空格位置
                start = end;
            }
        }
        return count;
    }

    public static String reorderSpaces(String text) {
        var length = text.length();
        var chars = new char[length];
        var result = new ArrayList<Range>();
        var spaceCount = splitAndCountSpaces(text, result);
        var parts = result.size();
        if (parts == 1) {
            // 空格放在右边
            var part = result.getFirst();
            text.getChars(part.start, part.end, chars, 0);
            Arrays.fill(chars, part.end - part.start, length, ' ');
        } else {
            // 填充单词和空格
            var div = spaceCount / (parts - 1);
            var pos = 0;
            for (var i = 0; i < parts; i++) {
                var range = result.get(i);
                if (i != 0) {
                    Arrays.fill(chars, pos, pos + div, ' ');
                    pos += div;
                }
                text.getChars(range.start(), range.end(), chars, pos);
                pos += range.end() - range.start();
            }
            // 填充剩下的空格
            Arrays.fill(chars, pos, chars.length, ' ');
        }
        return new String(chars, 0, length);
    }

    private record Range(int start, int end) {
    }
}
