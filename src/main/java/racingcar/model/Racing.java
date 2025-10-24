package racingcar.model;

import racingcar.model.vo.RacingCount;

public class Racing {

    private final Cars cars;
    private final RacingCount racingCount;

    public Racing(Cars cars, RacingCount racingCount) {
        this.cars = cars;
        this.racingCount = racingCount;
    }
}
