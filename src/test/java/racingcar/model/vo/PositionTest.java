package racingcar.model.vo;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class PositionTest {

    public static final int DEFAULT_POSITION = 0;
    public static final int MOVE_DISTANCE = 1;

    @ParameterizedTest
    @CsvSource(value = {"4", "5", "6"})
    @DisplayName("4 이상의 숫자가 입력되면 자동차가 한 칸 전진한다.")
    void move(int randomNumber) {
        //given
        int distance = DEFAULT_POSITION;

        //when
        Position position = new Position(distance);
        Position movedPosition = position.move(randomNumber);

        //then
        assertThat(movedPosition.getPosition()).isEqualTo(distance + MOVE_DISTANCE);
    }

    @ParameterizedTest
    @CsvSource(value = {"1", "2", "3"})
    @DisplayName("3 이하의 숫자가 입력되면 전진하지 않는다.")
    void notMoveWhenRandomNumberBelowThreshold(int randomNumber) {
        //given
        int distance = DEFAULT_POSITION;

        //when
        Position position = new Position(distance);
        Position movedPosition = position.move(randomNumber);

        //then
        assertThat(movedPosition.getPosition()).isEqualTo(position.getPosition());
    }
}