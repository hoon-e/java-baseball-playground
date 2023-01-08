package baseball;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class NumberBaseballTest {

    @ParameterizedTest
    @CsvSource(value = {
            "306,603,2",
            "713,317,2",
            "832,917,0",
            "476,764,3"
    }, delimiter = ',')
    void testCheckBall(String randomNumber, String userInput, int expected) {
        assertThat(NumberBaseball.checkBall(randomNumber, userInput)).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {
            "756,758,2",
            "613,139,0",
            "978,978,3",
            "625,529,1"
    }, delimiter = ',')
    void testCheckStrike(String randomNumber, String userInput, int expected) {
        assertThat(NumberBaseball.checkStrike(randomNumber, userInput)).isEqualTo(expected);
    }
}
