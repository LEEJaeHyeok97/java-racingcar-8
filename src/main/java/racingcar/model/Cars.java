package racingcar.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import racingcar.exception.ErrorMessage;
import racingcar.util.Separator;

public class Cars implements Iterable<Car> {

    public static final String CAR_NAME_DELIMITER = ",";
    public static final int DEFAULT_MAX_NUMBER = 0;
    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public int maxPosition() {
        return cars.stream()
                .mapToInt(Car::getCurrentPosition)
                .max()
                .orElse(DEFAULT_MAX_NUMBER);
    }

    public static Cars from(String carNames) {
        List<Car> separatedCars = new ArrayList<>();

        if (carNames.contains(CAR_NAME_DELIMITER)) {
            String[] names = Separator.splitNames(carNames);
            for (String name : names) {
                separatedCars.add(Car.of(name));
            }

            validateIsDuplicateCarName(separatedCars);
            return new Cars(separatedCars);
        }

        separatedCars.add(Car.of(carNames));
        return new Cars(separatedCars);
    }

    @Override
    public Iterator<Car> iterator() {
        return Collections.unmodifiableList(cars).iterator();
    }

    private static void validateIsDuplicateCarName(List<Car> separatedCars) {
        Set<Car> nonDuplicatedCarNames = new HashSet<>(separatedCars);
        if (nonDuplicatedCarNames.size() != separatedCars.size()) {
            throw new IllegalArgumentException(ErrorMessage.CAR_NAME_DUPLICATED.getMessage());
        }
    }
}
