package racingcar.util;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class SeparatorTest {

    @ParameterizedTest
    @ValueSource(strings = {"pobi,,woni,jun", "pobi,,,woni", "pobi,woni,jun,,,", "pobi,,,,,"})
    @DisplayName("연속으로 구분자가 입력된 경우 예외 발생 테스트")
    void continuousDelimiterTest(String input) {
        Separator separator = new Separator();
        assertThrows(IllegalArgumentException.class, () -> separator.splitNames(input));
    }
}