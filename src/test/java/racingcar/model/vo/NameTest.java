package racingcar.model.vo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class NameTest {

    @DisplayName("입력 이름이 비어있을 때 예외 테스트")
    @Test
    void NameEmptyExceptionTest() {
        //given
        String input = "";

        //when //then
        assertThrows(IllegalArgumentException.class, () -> new Name(input));
    }
}