package racingcar.model;

import java.util.ArrayList;
import java.util.List;
import racingcar.model.vo.RacingCount;

public class Racing {

    private final Cars cars;
    private final RacingCount racingCount;

    public Racing(Cars cars, RacingCount racingCount) {
        this.cars = cars;
        this.racingCount = racingCount;
    }

    public List<Car> getCars() {
        return cars.getCars();
    }

    public int getRacingCount() {
        return racingCount.getCount();
    }

    public void deductCount() {
        racingCount.deductCount();
    }

    public Cars getRoundResult() {
        return cars;
    }

    public static Racing of(Cars cars, RacingCount racingCount) {
        return new Racing(cars, racingCount);
    }

    public List<String> calculateWinners() {
        List<String> winners = new ArrayList<>();

        for (Car car : cars.getCars()) {
            if (car.getCurrentPosition() == cars.getMaxPosition()) {
                winners.add(car.getName());
            }
        }

        return winners;
    }
}
