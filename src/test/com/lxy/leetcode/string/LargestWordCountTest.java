package com.lxy.leetcode.string;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class LargestWordCountTest {
    public static Stream<Arguments> arguments() {
        return Stream.of(
                Arguments.of(new String[]{"Hello userTwooo", "Hi userThree",
                                "Wonderful day Alice", "Nice day userThree", "Who is alice"},
                        new String[]{"Alice", "userTwo", "userThree", "Alice", "alice"}, "Alice"),
                Arguments.of(new String[]{"How is leetcode for everyone",
                                "Leetcode is useful for practice"},
                        new String[]{"Bob", "Charlie"}, "Charlie"),
                Arguments.of(new String[]{"tP x M VC h lmD","D X XF w V","sh m Pgl",
                        "pN pa","C SL m G Pn v","K z UL B W ee","Yf yo n V U Za f np",
                        "j J sk f qr e v t","L Q cJ c J Z jp E","Be a aO","nI c Gb k Y C QS N",
                        "Yi Bts","gp No g s VR","py A S sNf","ZS H Bi De dj dsh","ep MA KI Q Ou"},
                        new String[]{"OXlq","IFGaW","XQPeWJRszU","Gb","HArIr","Gb","FnZd","FnZd",
                                "HArIr","OXlq","IFGaW","XQPeWJRszU","EMoUs","Gb","EMoUs","EMoUs"},
                        "FnZd")
        );
    }

    @ParameterizedTest
    @MethodSource("arguments")
    public void largestWordCountTest(String[] messages, String[] senders, String expected) {
        Assertions.assertEquals(expected, LargestWordCount.largestWordCount(messages, senders));
    }

    @ParameterizedTest
    @MethodSource("arguments")
    public void largestWordCountOptimizedTest(String[] messages, String[] senders, String expected) {
        Assertions.assertEquals(expected, LargestWordCount.largestWordCountOptimized(messages, senders));
    }
}
