package com.lxy.leetcode.array1d;

import com.lxy.leetcode.util.Util;
import static com.lxy.leetcode.array1d.NumArrayImplementations.NumArray;
import static com.lxy.leetcode.array1d.NumArrayImplementations.NumArraySimple;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.stream.Stream;

public class NumArrayTest {
    private static final int MAX_ARRAY_ABSOLUTE_VALUE = 100000;
    private static final int MIN_ARRAY_SIZE = 100;
    private static final int MAX_ARRAY_SIZE = 10000;
    private static final int RANDOM_ITERATION_COUNT = 10;
    private static final int ITERATION_COUNT = 20;

    private record NumArrayImpl(int[] numbers) {
        public int sumRange(int left, int right) {
            int sum = 0;
            for (int i = left; i <= right; i++) {
                sum += numbers[i];
            }
            return sum;
        }

        @Override
        public String toString() {
            return Util.toSimpleString(this);
        }
    }

    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.METHOD)
    @ArgumentsSource(value = NumArrayArgumentProvider.class)
    public @interface NumArrayArgumentTest {
        Class<?> implementation();
    }

    public static class NumArrayArgumentProvider implements ArgumentsProvider {

        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
            NumArrayArgumentTest numArrayArgumentTest =
                    context.getRequiredTestMethod().getAnnotation(NumArrayArgumentTest.class);
            if (numArrayArgumentTest == null) {
                throw new IllegalArgumentException(
                        "Test method must be annotated with NumArrayArgumentTest");
            }
            Class<?> implementation = numArrayArgumentTest.implementation();
            Constructor<?> constructor;
            try {
                constructor = implementation.getConstructor(int[].class);
            } catch (NoSuchMethodException e) {
                throw new IllegalArgumentException("Implementation class "
                        + implementation + " does not have a constructor with int[]");
            }
            return Stream.generate(NumArrayTest::randomArray)
                    .limit(RANDOM_ITERATION_COUNT)
                    .flatMap(array -> {
                        int length = array.length;
                        NumArrayImpl expected = new NumArrayImpl(array);
                        Object actual;
                        try {
                            //noinspection RedundantCast
                            actual = constructor.newInstance((Object) array);
                        } catch (InstantiationException |
                                 IllegalAccessException |
                                 InvocationTargetException e) {
                            throw new IllegalArgumentException(
                                    "Failed to instantiate implementation class "
                                            + implementation, e);
                        }
                        return Stream.generate(() -> {
                            int left = Util.randomInt(length);
                            int right = Util.randomInt(left, length);
                            return Arguments.of(expected, actual, left, right);
                        }).limit(ITERATION_COUNT);
                    });
        }
    }

    private static int[] randomArray() {
        int size = Util.randomIntClosed(MIN_ARRAY_SIZE, MAX_ARRAY_SIZE);
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = Util.randomIntClosed(-MAX_ARRAY_ABSOLUTE_VALUE, MAX_ARRAY_ABSOLUTE_VALUE);
        }
        return array;
    }

    @ParameterizedTest
    @NumArrayArgumentTest(implementation = NumArray.class)
    public void numArrayTest(NumArrayImpl expected, NumArray actual, int left, int right) {
        Assertions.assertEquals(expected.sumRange(left, right), actual.sumRange(left, right));
    }

    @ParameterizedTest
    @NumArrayArgumentTest(implementation = NumArraySimple.class)
    public void numArraySimpleTest(NumArrayImpl expected, NumArraySimple actual, int left, int right) {
        Assertions.assertEquals(expected.sumRange(left, right), actual.sumRange(left, right));
    }
}
