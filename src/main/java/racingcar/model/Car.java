package racingcar.model;

import java.util.Objects;
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

    public String getName() {
        return name.getName();
    }

    public int getCurrentPosition() {
        return position.getPosition();
    }

    public static Car of(String name) {
        return new Car(Name.of(name));
    }

    public void move(int randomNumber) {
        position.move(randomNumber);
    }

    public boolean isAtPosition(int target) {
        return position.getPosition() == target;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof Car)) {
            return false;
        }
        Car car = (Car) object;
        return name.equals(car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
