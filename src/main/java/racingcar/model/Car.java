package racingcar.model;

import racingcar.model.vo.Name;
import racingcar.model.vo.Position;

public class Car {

    private final Name name;
    private final Position position;

    public Car(Name name, Position position) {
        this.name = name;
        this.position = position;
    }
}
