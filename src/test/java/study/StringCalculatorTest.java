package study;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class StringCalculatorTest {
    StringCalculator cal = new StringCalculator();
    String value;

    @ParameterizedTest
    @ValueSource(ints = {10})
    void calculatorTest1(int expected) {
        value = "2 + 3 * 4 / 2";
        assertThat(cal.calculateString(value)).isEqualTo(expected);
    }
}
