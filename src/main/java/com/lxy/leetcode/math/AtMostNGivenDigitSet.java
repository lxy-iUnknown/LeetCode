package com.lxy.leetcode.math;

/**
 * <a href="https://leetcode.cn/problems/numbers-at-most-n-given-digit-set/">最大为N的数字组合</a>
 */
public class AtMostNGivenDigitSet {
    private static final int RADIX = 10;
    private static final int MAX_DIGITS = 10;

    // p ^ n for n in [0, 9] for p in [1, 9]
    private static final int[][] POWERS = {
            null, // sentinel
            new int[]{1 /* sentinel */, 1, 1, 1, 1, 1, 1, 1, 1, 1},
            new int[]{1 /* sentinel */, 2, 4, 8, 16, 32, 64, 128, 256, 512,},
            new int[]{1 /* sentinel */, 3, 9, 27, 81, 243, 729, 2187, 6561, 19683},
            new int[]{1 /* sentinel */, 4, 16, 64, 256, 1024, 4096, 16384, 65536, 262144},
            new int[]{1 /* sentinel */, 5, 25, 125, 625, 3125, 15625, 78125, 390625, 1953125},
            new int[]{1 /* sentinel */, 6, 36, 216, 1296, 7776, 46656, 279936, 1679616, 10077696},
            new int[]{1 /* sentinel */, 7, 49, 343, 2401, 16807, 117649, 823543, 5764801, 40353607},
            new int[]{1 /* sentinel */, 8, 64, 512, 4096, 32768, 262144, 2097152, 16777216, 134217728},
            new int[]{1 /* sentinel */, 9, 81, 729, 6561, 59049, 531441, 4782969, 43046721, 387420489}
    };
    // f(p, n) = p + p^2 + ... + p^n
    //         = 0 (n = 0), n (p == 1), p * (p ^ n - 1) / (p - 1) (else)
    // f(p, n) for n in [1, 9] for p in [1, 9]
    // prefix sums of POWERS array
    private static final int[][] POWER_SUMS = {
            null, // sentinel
            new int[]{0 /* sentinel */, 1, 2, 3, 4, 5, 6, 7, 8, 9},
            new int[]{0 /* sentinel */, 2, 6, 14, 30, 62, 126, 254, 510, 1022},
            new int[]{0 /* sentinel */, 3, 12, 39, 120, 363, 1092, 3279, 9840, 29523},
            new int[]{0 /* sentinel */, 4, 20, 84, 340, 1364, 5460, 21844, 87380, 349524},
            new int[]{0 /* sentinel */, 5, 30, 155, 780, 3905, 19530, 97655, 488280, 2441405},
            new int[]{0 /* sentinel */, 6, 42, 258, 1554, 9330, 55986, 335922, 2015538, 12093234},
            new int[]{0 /* sentinel */, 7, 56, 399, 2800, 19607, 137256, 960799, 6725600, 47079207},
            new int[]{0 /* sentinel */, 8, 72, 584, 4680, 37448, 299592, 2396744, 19173960, 153391688},
            new int[]{0 /* sentinel */, 9, 90, 819, 7380, 66429, 597870, 5380839, 48427560, 435848049}
    };

    public static int atMostNGivenDigitSet(String[] digits, int n) {
        return new DigitCollection(digits).atMostNGivenDigitSet(n);
    }

    private enum SearchResultKind {
        FOUND, NOT_FOUND, TOO_SMALL
    }

    private record SearchResult(int value, SearchResultKind kind) {

    }

    private static class DigitCollection {
        private final String[] digits;
        // Cache
        private final int[] powers;

        public DigitCollection(String[] digits) {
            this.digits = digits;
            this.powers = POWERS[digitLength()];
        }

        private int digitLength() {
            return digits.length;
        }

        public int digitValue(int n) {
            return digits[n].charAt(0) - '0';
        }

        public int powerMul(int p, int n) {
            return p == 0 ? 0 : p * powers[n];
        }

        @SuppressWarnings("DataFlowIssue")
        public int powerSum(int n) {
            return POWER_SUMS[digitLength()][n];
        }

        private SearchResult generateResult(int value) {
            var start = 0;
            var end = digitLength() - 1;
            while (start <= end) {
                var mid = (start + end) / 2;
                var midValue = digitValue(mid);
                if (midValue < value) {
                    start = mid + 1;
                } else if (midValue > value) {
                    end = mid - 1;
                } else {
                    return new SearchResult(mid, SearchResultKind.FOUND);
                }
            }
            if (value < digitValue(0)) {
                return new SearchResult(-1, SearchResultKind.TOO_SMALL);
            }
            return new SearchResult(start, SearchResultKind.NOT_FOUND);
        }

        private int generateResults(int n, SearchResult[] results) {
            var position = MAX_DIGITS;
            while (n != 0) {
                var div = n / RADIX;
                var digit = n - div * RADIX;
                results[--position] = generateResult(digit);
                n = div;
            }
            return position;
        }

        public int atMostNGivenDigitSet(int n) {
            var results = new SearchResult[MAX_DIGITS];
            var position = generateResults(n, results);
            var power = (MAX_DIGITS - 1) - position;
            var sum = powerSum(power);
            for (var i = position; i < MAX_DIGITS; i++) {
                var result = results[i];
                var kind = result.kind();
                var value = result.value();
                switch (kind) {
                    case FOUND -> {
                        if (i == MAX_DIGITS - 1) {
                            value++;
                        }
                        sum += powerMul(value, power);
                    }
                    case NOT_FOUND -> {
                        // Don't need to branch, add rest
                        sum += powerMul(value, power);
                        return sum;
                    }
                    case TOO_SMALL -> {
                        // Don't need to branch, return directly
                        return sum;
                    }
                }
                power--;
            }
            return sum;
        }
    }
}
