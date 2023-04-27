package com.lxy.leetcode.string;

import com.lxy.leetcode.util.TestUtil;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Set;
import java.util.stream.Stream;

public class FrequencySortTest {
    public static Stream<Arguments> arguments() {
        return Stream.of(
                Arguments.of("tree", Set.of("eert")),
                Arguments.of("aaccca", Set.of("aaaccc", "cccaaa")),
                Arguments.of("ThiThathat", Set.of(
                        "hhhTTttaai", "hhhttTTaai", "hhhaaTTtti",
                        "hhhTTaatt", "hhhaattTTi", "hhhTTaatti"))
        );
    }

    @ParameterizedTest
    @MethodSource("arguments")
    public void frequencySortTest(String s, Set<String> expected) {
        s = FrequencySort.frequencySort(s);
        if (!expected.contains(s)) {
            TestUtil.assertFail("Possible results " + expected + " do not contain actual result \"" + s + "\"");
        }
    }
}
