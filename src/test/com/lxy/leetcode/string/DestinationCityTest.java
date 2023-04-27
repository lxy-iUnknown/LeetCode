package com.lxy.leetcode.string;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

public class DestinationCityTest {
    public static Stream<Arguments> arguments() {
        return Stream.of(
                Arguments.of(List.of(
                        List.of("London", "New York"),
                        List.of("New York", "Lima"),
                        List.of("Lima", "Sao Paulo")), "Sao Paulo"),
                Arguments.of(List.of(
                        List.of("B", "C"),
                        List.of("D", "B"),
                        List.of("C", "A")), "A"),
                Arguments.of(List.of(List.of("A", "B")), "B"),
                Arguments.of(List.of(
                        List.of("C", "D"),
                        List.of("E", "F"),
                        List.of("A", "B"),
                        List.of("D", "E"),
                        List.of("B", "C")), "F")

        );
    }

    @ParameterizedTest
    @MethodSource("arguments")
    public void destinationCityTest(List<List<String>> paths, String expected) {
        Assertions.assertEquals(expected, DestinationCity.destCity(paths));
    }

    @ParameterizedTest
    @MethodSource("arguments")
    public void destinationCityOptimizedTest(List<List<String>> paths, String expected) {
        Assertions.assertEquals(expected, DestinationCity.destCityOptimized(paths));
    }
}
