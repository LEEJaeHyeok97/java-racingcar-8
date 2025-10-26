package racingcar.model;

import java.util.ArrayList;
import java.util.List;
import racingcar.model.vo.RacingCount;
import racingcar.util.NumberGenerator;

public class Racing {

    public static final int RACE_END_COUNT = 0;
    private final Cars cars;
    private final RacingCount racingCount;

    public Racing(Cars cars, RacingCount racingCount) {
        this.cars = cars;
        this.racingCount = racingCount;
    }

    public Cars getRoundResult() {
        return cars;
    }

    public static Racing of(Cars cars, RacingCount racingCount) {
        return new Racing(cars, racingCount);
    }

    public boolean hasNextRound() {
        return racingCount.getCount() > RACE_END_COUNT;
    }

    public void proceedOneRound(NumberGenerator numberGenerator) {
        for (Car car : cars) {
            car.move(numberGenerator.generateNumber());
        }

        racingCount.deductCount();
    }

    public List<String> calculateWinners() {
        List<String> winners = new ArrayList<>();

        for (Car car : cars) {
            if (car.getCurrentPosition() == cars.getMaxPosition()) {
                winners.add(car.getName());
            }
        }

        return winners;
    }
}
