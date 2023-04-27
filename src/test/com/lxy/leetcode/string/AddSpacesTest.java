package com.lxy.leetcode.string;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class AddSpacesTest {
    public static Stream<Arguments> arguments() {
        return Stream.of(
                Arguments.of("EnjoyYourCoffee",
                        new int[]{5, 9},
                        "Enjoy Your Coffee"),
                Arguments.of("LeetcodeHelpsMeLearn",
                        new int[]{8, 13, 15},
                        "Leetcode Helps Me Learn"),
                Arguments.of("icodeinpython",
                        new int[]{1, 5, 7, 9},
                        "i code in py thon"),
                Arguments.of("spacing",
                        new int[]{0, 1, 2, 3, 4, 5, 6},
                        " s p a c i n g")
        );
    }

    @ParameterizedTest
    @MethodSource("arguments")
    public void addSpacesTest(String s, int[] spaces, String expected) {
        Assertions.assertEquals(expected, AddSpaces.addSpaces(s, spaces));
    }
}
