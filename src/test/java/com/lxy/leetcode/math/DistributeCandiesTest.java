package com.lxy.leetcode.math;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.FieldSource;

import java.util.stream.IntStream;

public class DistributeCandiesTest {
    private static final Arguments[] ARGUMENTS = IntStream.rangeClosed(1, 10)
            .boxed()
            .flatMap(n ->
                    IntStream.rangeClosed(1, 10)
                            .mapToObj(k -> Arguments.of(n, k)))
            .toArray(Arguments[]::new);

    private static int distributeCandiesLoop(int n, int limit) {
        var aMin = Math.max(0, n - 2 * limit);
        var aMax = Math.min(n, limit);
        var sum = 0;
        for (var a = aMin; a <= aMax; a++) {
            var bMin = Math.max(0, n - a - limit);
            var bMax = Math.min(0, n - a - limit) + limit;
            sum += bMax - bMin + 1;
        }
        return sum;
    }

    @ParameterizedTest
    @FieldSource("ARGUMENTS")
    public void distributeCandiesTest(int n, int limit) {
        Assertions.assertEquals(distributeCandiesLoop(n, limit), DistributeCandies.distributeCandies(n, limit));
    }
}
