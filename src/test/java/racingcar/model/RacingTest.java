package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.vo.RacingCount;
import racingcar.util.stub.FixedNumberGenerator;

class RacingTest {

    @DisplayName("라운드 횟수가 0보다 크면 다음 라운드가 존재한다.")
    @Test
    void hasNextRoundReturnTrueWhenCountIsPositive() {
        //given
        Racing racing = Racing.of(Cars.from("pobi"), RacingCount.from("2"));

        //when //then
        assertThat(racing.hasNextRound()).isTrue();
    }

    @DisplayName("라운드 수가 0이면 다음 라운드가 존재하지 않는다.")
    @Test
    void hasNextRoundReturnFalseWhenCountIsZero() {
        //given
        Racing racing = Racing.of(Cars.from("pobi"), RacingCount.from("1"));
        racing.proceedOneRound(() -> 9);

        //when //then
        assertThat(racing.hasNextRound()).isFalse();
    }

    @DisplayName("모든 자동차가 한 번씩 이동을 시도하고 난 후 시도 횟수가 1 감소한다.")
    @Test
    void proceedOneRoundMovesAllCarsAndDecreasesCount() {
        //given
        Cars cars = Cars.from("pobi,woni,jun");
        Racing racing = Racing.of(cars, RacingCount.from("1"));
        FixedNumberGenerator generator = new FixedNumberGenerator(9);

        //when
        racing.proceedOneRound(generator);

        //then
        assertThat(racing.hasNextRound()).isFalse();
    }

    @DisplayName("최대 위치에 도달한 자동차가 우승자로 계산된다.")
    @Test
    void calculateSingleWinner() {
        //given
        Cars cars = Cars.from("pobi,woni,jun");
        Racing racing = Racing.of(cars, RacingCount.from("1"));
        FixedNumberGenerator move = new FixedNumberGenerator(9);
        FixedNumberGenerator stop = new FixedNumberGenerator(0);

        //when
        cars.getCars().get(0).move(move.generateNumber());
        cars.getCars().get(1).move(stop.generateNumber());
        cars.getCars().get(2).move(stop.generateNumber());

        List<String> winners = racing.calculateWinners();

        //then
        assertThat(winners).containsExactly("pobi");
    }

    @DisplayName("여러 자동차가 동일한 최대 위치에 도달하면 공동 우승자로 계산된다.")
    @Test
    void calculateMultipleWinners() {
        //given
        Cars cars = Cars.from("pobi,woni,jun");
        Racing racing = Racing.of(cars, RacingCount.from("1"));
        FixedNumberGenerator move = new FixedNumberGenerator(9);

        //when
        for (Car car : cars.getCars()) {
            car.move(move.generateNumber());
        }

        List<String> winners = racing.calculateWinners();

        assertThat(winners).containsExactlyInAnyOrder("pobi", "woni", "jun");
    }
}