package racingcar.model;

import racingcar.model.vo.RacingCount;

public class Racing {

    public static final String DEFAULT_RACING_COUNT = "0";
    private final Cars cars;
    private final RacingCount racingCount;

    public Racing(Cars cars, RacingCount racingCount) {
        this.cars = cars;
        this.racingCount = racingCount;
    }

    public Cars getRoundResult() {
        return cars;
    }

    public static Racing of(Cars cars) {
        return new Racing(cars, RacingCount.from(DEFAULT_RACING_COUNT));
    }
}
