package racingcar.model.vo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RacingCountTest {

    public static final String INVALID_MIN_COUNT = "0";

    @DisplayName("경주 시도 횟수에 공백이 입력되면 예외를 발생한다.")
    @Test
    void racingCountEmptyExceptionTest() {
        //given
        String input = "";

        //when //then
        assertThrows(IllegalArgumentException.class, () -> RacingCount.from(input));
    }

    @DisplayName("최소 경주 시도 횟수 이하의 값이 입력되면 예외를 발생한다.")
    @Test
    void racingCountMaxLengthLimitExceedExceptionTest() {
        //given
        String input = INVALID_MIN_COUNT;

        //when //then
        assertThrows(IllegalArgumentException.class, () -> RacingCount.from(input));
    }

    @DisplayName("숫자가 아닌 값이 경주 시도 횟수에 입력되면 예외를 발생한다.")
    @Test
    void racingCountNonNumericInput() {
        //given
        String input = "javajigi";

        //when //then
        assertThrows(IllegalArgumentException.class, () -> RacingCount.from(input));
    }
}