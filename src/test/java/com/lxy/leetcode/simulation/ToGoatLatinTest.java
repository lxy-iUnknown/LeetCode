package com.lxy.leetcode.simulation;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.FieldSource;

public class ToGoatLatinTest {

    public static final Arguments[] ARGUMENTS = new Arguments[]{
            Arguments.of(
                    "Are",
                    "Aremaa"
            ),
            Arguments.of(
                    "The",
                    "heTmaa"
            ),
            Arguments.of(
                    "I speak Goat Latin",
                    "Imaa peaksmaaa oatGmaaaa atinLmaaaaa"
            ),
            Arguments.of(
                    "The quick brown fox jumped over the lazy dog",
                    "heTmaa uickqmaaa rownbmaaaa oxfmaaaaa umpedjmaaaaaa overmaaaaaaa hetmaaaaaaaa azylmaaaaaaaaa ogdmaaaaaaaaaa"
            )
    };

    @ParameterizedTest
    @FieldSource("ARGUMENTS")
    public void toGoatLatinTest(String sentence, String expected) {
        Assertions.assertEquals(expected, ToGoatLatin.toGoatLatin(sentence));
    }
}
