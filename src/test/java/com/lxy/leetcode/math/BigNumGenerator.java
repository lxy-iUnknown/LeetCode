package com.lxy.leetcode.math;

import org.junit.jupiter.params.provider.Arguments;

import java.math.BigInteger;
import java.util.function.BiFunction;
import java.util.random.RandomGenerator;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class BigNumGenerator {
    private final BiFunction<BigInteger, BigInteger, BigInteger> op;
    private final int base;

    private static final int RANDOM_INT_COUNT = 50;
    private static final RandomGenerator GENERATOR = RandomGenerator.getDefault();

    public BigNumGenerator(BiFunction<BigInteger, BigInteger, BigInteger> op) {
        this(op, 10);
    }

    public BigNumGenerator(BiFunction<BigInteger, BigInteger, BigInteger> op, int base) {
        this.op = op;
        this.base = base;
    }

    public Stream<Arguments> generate(int n1, int n2) {
        var random1 = new RandomBigNum(n1);
        var random2 = new RandomBigNum(n2);
        return IntStream.rangeClosed(1, RANDOM_INT_COUNT)
                .sequential()
                .mapToObj(_ -> {
                    var b1 = random1.next();
                    var b2 = random2.next();
                    return Arguments.of(
                            b1.toString(base),
                            b2.toString(base),
                            op.apply(b1, b2).toString(base)
                    );
                });
    }

    @SuppressWarnings("ClassCanBeRecord")
    private static class RandomBigNum {
        private final byte[] bytes;

        public RandomBigNum(int n) {
            bytes = new byte[n];
        }

        public BigInteger next() {
            GENERATOR.nextBytes(bytes);
            bytes[0] &= (byte) ~0b1111_1111;
            return new BigInteger(bytes);
        }
    }
}
