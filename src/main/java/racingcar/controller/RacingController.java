package racingcar.controller;

import java.util.ArrayList;
import java.util.List;
import racingcar.model.Car;
import racingcar.model.Cars;
import racingcar.model.Racing;
import racingcar.model.vo.RacingCount;
import racingcar.util.NumberGenerator;
import racingcar.util.RandomNumberGenerator;
import racingcar.util.Separator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingController {

    public static final String CAR_NAME_DELIMITER = ",";
    public static final int RACE_END_COUNT = 0;
    private final InputView inputView;
    private final OutputView outputView;
    private final NumberGenerator numberGenerator = new RandomNumberGenerator();

    public RacingController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        String input = inputView.inputCarName();
        String raceCount = inputView.inputRaceCount();

        Cars cars = Cars.of(getCars(input));
        RacingCount racingCount = RacingCount.from(raceCount);
        Racing racing = Racing.of(cars, racingCount);

        outputView.printRoundResultMessage();
        while (racing.getRacingCount() > RACE_END_COUNT) {
            for (Car car : racing.getCars()) {
                car.move(numberGenerator.generateNumber());
            }
            outputView.printRoundResult(racing);
            racing.deductCount();
        }

        List<String> winnerNames = racing.calculateWinners();
        outputView.printResult(winnerNames);
    }

    private static List<Car> getCars(String input) {
        List<Car> cars = new ArrayList<>();
        if (input.contains(CAR_NAME_DELIMITER)) {
            String[] splittedNames = Separator.splitNames(input);
            for (String name : splittedNames) {
                Car car = Car.of(name);
                cars.add(car);
            }

            return cars;
        }

        cars.add(Car.of(input));
        return cars;
    }
}
