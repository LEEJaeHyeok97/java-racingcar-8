package racingcar.model.vo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RacingCountTest {

    @DisplayName("경주 시도 횟수에 공백이 입력된 경우 예외 테스트")
    @Test
    void racingCountEmptyExceptionTest() {
        //given
        String input = "";

        //when //then
        assertThrows(IllegalArgumentException.class, () -> RacingCount.from(input));
    }
}