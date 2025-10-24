package racingcar.model;

import racingcar.model.vo.Name;
import racingcar.model.vo.Position;

public class Car {

    public static final int DEFAULT_POSITION = 0;
    private final Name name;
    private final Position position;

    public Car(Name name) {
        this.name = name;
        this.position = Position.of(DEFAULT_POSITION);
    }

    public Car of(Name name) {
        return new Car(name);
    }
}
