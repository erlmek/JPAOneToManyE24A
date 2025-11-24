package org.example.jpaonetomanye24a.model;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class KommuneTest {

    @Test
    void test() {
        if (3>4)
        fail("Det virker ikke");
    }

    @Test
    void test2() {
        assertEquals("ABC", "ABC");
    }

    @Test
    @Disabled
    void testDiv0() {
        int i = 10;
        int y = 0;
        assertEquals(0, i/y);
    }

    @Test
    @DisplayName("sammenligner arrays")
    void testArr() {
        int[] numbers = {12,3,4,1};
        int[] expected = {1,3,4,12};
        Arrays.sort(numbers);
        assertArrayEquals(expected, numbers, () -> "Der er fejl" + Arrays.toString(numbers) + "i array");
    }

    @DisplayName("paramtest med 3 arrays")
    @ParameterizedTest
    @MethodSource("sortnumbersArgument")
    void testArrParm(int[] numbers, int[] expected) {
        Arrays.sort(numbers);
        assertArrayEquals(expected, numbers, () -> "der er fejl " + Arrays.toString(numbers) + " i array");
    }


    private static Stream<Arguments> sortnumbersArgument() {
        return Stream.of(
                Arguments.of(IntStream.of(1, 2, 3).toArray(), IntStream.of(1,2,3).toArray())
        );
    }


}