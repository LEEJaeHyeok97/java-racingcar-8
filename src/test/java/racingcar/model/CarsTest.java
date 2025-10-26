package racingcar.model;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarsTest {

    @DisplayName("중복된 자동차 이름이 입력되면 예외를 발생한다.")
    @Test
    void duplicateCarName() {
        //given
        String carNames = "pobi,woni,woni";

        //when //then
        assertThrows(IllegalArgumentException.class, () -> Cars.from(carNames));
    }
}