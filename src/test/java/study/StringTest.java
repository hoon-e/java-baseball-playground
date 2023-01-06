package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTest {
    @Test
    void replace() {
        String actual = "abc".replace("b", "d");
        assertThat(actual).isEqualTo("adc");
    }

    @Test
    void splitTest() {
        String[] actual = "1,2".split(",");
        assertThat(actual).contains("1").contains("2");
        // 2개를 연달아?
    }

    @Test
    void splitTest2() {
        String[] actual = "1".split(",");
        assertThat(actual).contains("1");
    }

    @Test
    void splitTest3() {
        String substring = "(1,2)".substring(1, 4);
        assertThat(substring).isEqualTo("1,2");
    }

    @Test
    @DisplayName("StringIndexOutOfBoundsException 확인.")
    void splitTest4() {
        String input = "abc";

        assertThatThrownBy(() -> {
            char s = input.charAt(input.length());
            System.out.println(s);
        })
                .isInstanceOf(StringIndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range")
                .hasMessageContaining(String.valueOf(input.length()));
    }
}
