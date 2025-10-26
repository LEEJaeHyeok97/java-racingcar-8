package racingcar.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racingcar.util.NumberGenerator;
import racingcar.util.stub.FixedNumberGenerator;

class CarTest {

    @ParameterizedTest
    @CsvSource(value = {"4", "5", "6", "7", "8", "9"})
    @DisplayName("랜덤 숫자가 4 이상일 경우 자동차는 한 칸 전진한다.")
    @Test
    void carMovesWhenRandomNumberIsFourOrMore() {
        //given
        Car car = Car.of("pobi");
        NumberGenerator generator = new FixedNumberGenerator(4);

        //when
        car.move(generator.generateNumber());

        //then
        Assertions.assertThat(car.getCurrentPosition()).isEqualTo(1);
    }
}