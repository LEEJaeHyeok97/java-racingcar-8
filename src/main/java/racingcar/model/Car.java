package racingcar.model;

import racingcar.model.vo.Position;

public class Car {

    private final String name;
    private final Position position;

    public Car(String name, Position position) {
        this.name = name;
        this.position = position;
    }
}
