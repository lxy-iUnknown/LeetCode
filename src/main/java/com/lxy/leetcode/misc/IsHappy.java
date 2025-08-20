package com.lxy.leetcode.misc;

import com.lxy.leetcode.util.CycleDetector;
import com.lxy.leetcode.util.ILinkedNode;

import java.util.Arrays;
import java.util.HashSet;

/**
 * <a href="https://leetcode.cn/problems/happy-number/">快乐数</a>
 */
public class IsHappy {
    // Sorted cycle members: 4, 16, 37, 58, 89, 145, 42, 20
    private static final int[] SORTED_CYCLE_MEMBERS = new int[]{
            4, 16, 20, 37, 42, 58, 89, 145
    };

    private static int squareDigitSum(int n) {
        var sum = 0;
        while (n > 0) {
            var temp = n / 10;
            var digit = n - temp * 10;
            sum += digit * digit;
            n = temp;
        }
        return sum;
    }

    public static boolean isHappy(int n) {
        var set = new HashSet<Integer>();
        for (; ; ) {
            if (n == 1) {
                return true;
            }
            if (set.contains(n)) {
                return false;
            }
            set.add(n);
            n = squareDigitSum(n);
        }
    }

    /**
     * 判断一个数是否为快乐数<br>
     * 事实上，反复迭代的过程可视为一个隐式链表，因此要想判断是否为快乐数，只需判断链表是否有环，
     * 可使用快慢指针法（参见{@link CycleDetector#detect(ILinkedNode)}）
     *
     * @param n 数字n
     * @return 是否为快乐数
     */
    public static boolean isHappyLinkedList(int n) {
        return CycleDetector.detect(new HappyLinkedNode(n)) == null;
    }

    public static boolean isHappyMath(int n) {
        while (n != 1 && Arrays.binarySearch(SORTED_CYCLE_MEMBERS, n) < 0) {
            n = squareDigitSum(n);
        }
        return n == 1;
    }

    private record HappyLinkedNode(int value) implements ILinkedNode<HappyLinkedNode> {

        @Override
        public boolean equals(HappyLinkedNode other) {
            return value == other.value();
        }

        @Override
        public HappyLinkedNode next() {
            return new HappyLinkedNode(squareDigitSum(value));
        }

        @Override
        public boolean isNull() {
            return value == 1;
        }
    }
}
