package racingcar.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import racingcar.util.Separator;

public class Cars {

    public static final String CAR_NAME_DELIMITER = ",";
    public static final int DEFAULT_MAX_NUMBER = 0;
    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public List<Car> getCars() {
        return cars;
    }

    public int getMaxPosition() {
        return cars.stream()
                .mapToInt(Car::getCurrentPosition)
                .max()
                .orElse(DEFAULT_MAX_NUMBER);
    }

    public static Cars of(List<Car> cars) {
        return new Cars(cars);
    }

    public static Cars from(String carNames) {
        List<Car> cars = new ArrayList<>();

        if (carNames.contains(CAR_NAME_DELIMITER)) {
            String[] names = Separator.splitNames(carNames);
            for (String name : names) {
                cars.add(Car.of(name));
            }

            Cars newCars = new Cars(cars);
            validateIsDuplicatdCarName(newCars);
            return newCars;
        }

        cars.add(Car.of(carNames));
        return new Cars(cars);
    }

    private static void validateIsDuplicatdCarName(Cars cars) {
        Set<Car> nonDuplicatedCarNames = new HashSet<>(cars.getCars());
        if (nonDuplicatedCarNames.size() != cars.cars.size()) {
            throw new IllegalArgumentException("같은 자동차의 이름을 중복으로 입력할 수 없습니다.");
        }
    }
}
