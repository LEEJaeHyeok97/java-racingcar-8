package racingcar.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Cars {

    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public Cars from(List<String> carNames) {
        validateIsDuplicatdCarName(carNames);
        List<Car> mappedCars = carNames.stream()
                .map(Car::of)
                .toList();

        return new Cars(mappedCars);
    }

    private void validateIsDuplicatdCarName(List<String> carNames) {
        Set<String> nonDuplicatedCarNames = new HashSet<>(carNames);
        if (nonDuplicatedCarNames.size() != carNames.size()) {
            throw new IllegalArgumentException("같은 자동차의 이름을 중복으로 입력할 수 없습니다.");
        }
    }
}
