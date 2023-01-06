package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class SetTest {
    private Set<Integer> numbers;

    @BeforeEach
    void setUp() {
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(7);
    }

    @Test
    void setTest1() {
        assertThat(numbers).hasSize(numbers.size());
    }

    @Test
    void testContains() {
        assertThat(numbers).contains(1);
        assertThat(numbers).contains(2);
        assertThat(numbers).contains(3);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void testContains2(int input) {
        assertThat(numbers).contains(input);
    }

    // csv로 인풋을 받아서 처리
    @ParameterizedTest
    @CsvSource(value = {
            "1:true",
            "2:true",
            "3:true",
            "4:false",
            "5:false"
    }, delimiter = ':')
    void testContains4(int input, boolean expected) {
        assertThat(numbers.contains(input)).isEqualTo(expected);
    }
}
