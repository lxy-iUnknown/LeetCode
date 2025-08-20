package com.lxy.leetcode.misc;

import java.util.StringJoiner;

/**
 * <a href="https://leetcode.cn/problems/integer-to-english-words/">整数转换英文表示</a>
 */
public class NumberToWords {

    private static final String[] WORDS_1_TO_99 = new String[]{
            null, // Sentinel
            "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten",
            "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen",
            "Sixteen", "Seventeen", "Eighteen", "Nineteen", "Twenty",
            "Twenty One", "Twenty Two", "Twenty Three", "Twenty Four", "Twenty Five",
            "Twenty Six", "Twenty Seven", "Twenty Eight", "Twenty Nine", "Thirty",
            "Thirty One", "Thirty Two", "Thirty Three", "Thirty Four", "Thirty Five",
            "Thirty Six", "Thirty Seven", "Thirty Eight", "Thirty Nine", "Forty",
            "Forty One", "Forty Two", "Forty Three", "Forty Four", "Forty Five",
            "Forty Six", "Forty Seven", "Forty Eight", "Forty Nine", "Fifty",
            "Fifty One", "Fifty Two", "Fifty Three", "Fifty Four", "Fifty Five",
            "Fifty Six", "Fifty Seven", "Fifty Eight", "Fifty Nine", "Sixty",
            "Sixty One", "Sixty Two", "Sixty Three", "Sixty Four", "Sixty Five",
            "Sixty Six", "Sixty Seven", "Sixty Eight", "Sixty Nine", "Seventy",
            "Seventy One", "Seventy Two", "Seventy Three", "Seventy Four", "Seventy Five",
            "Seventy Six", "Seventy Seven", "Seventy Eight", "Seventy Nine", "Eighty",
            "Eighty One", "Eighty Two", "Eighty Three", "Eighty Four", "Eighty Five",
            "Eighty Six", "Eighty Seven", "Eighty Eight", "Eighty Nine", "Ninety",
            "Ninety One", "Ninety Two", "Ninety Three", "Ninety Four", "Ninety Five",
            "Ninety Six", "Ninety Seven", "Ninety Eight", "Ninety Nine"
    };

    private static final int HUNDRED = 100;
    private static final int THOUSAND = 1_000;
    private static final int MILLION = 1_000_000;
    private static final int BILLION = 1_000_000_000;

    private static void appendNumberSegment(StringJoiner sj, int number) {
        if (number >= 100) {
            var hundreds = number / HUNDRED;
            sj.add(WORDS_1_TO_99[hundreds]).add("Hundred");
            number -= hundreds * HUNDRED;
        }
        if (number > 0) {
            sj.add(WORDS_1_TO_99[number]);
        }
    }

    public static String numberToWords(int number) {
        if (number == 0) {
            // Special case
            return "Zero";
        }
        var sj = new StringJoiner(" ");
        if (number >= BILLION) {
            var billions = number / BILLION;
            // 1 <= billions <= 2
            sj.add(billions == 1 ? "One Billion" : "Two Billion");
            number -= billions * BILLION;
        }
        if (number >= MILLION) {
            var millions = number / MILLION;
            appendNumberSegment(sj, millions);
            sj.add("Million");
            number -= millions * MILLION;
        }
        if (number >= THOUSAND) {
            var thousands = number / THOUSAND;
            appendNumberSegment(sj, thousands);
            sj.add("Thousand");
            number -= thousands * THOUSAND;
        }
        appendNumberSegment(sj, number);
        return sj.toString();
    }
}
