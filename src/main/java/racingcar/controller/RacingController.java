package racingcar.controller;

import java.util.List;
import racingcar.model.Car;
import racingcar.model.Cars;
import racingcar.model.Racing;
import racingcar.model.vo.RacingCount;
import racingcar.util.NumberGenerator;
import racingcar.util.RandomNumberGenerator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingController {

    public static final int RACE_END_COUNT = 0;
    private final InputView inputView;
    private final OutputView outputView;
    private final NumberGenerator numberGenerator = new RandomNumberGenerator();

    public RacingController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        racingStart(createRacing());
    }

    private Racing createRacing() {
        return Racing.of(getCars(inputCarName()), getRaceCount(inputRaceCount()));
    }

    private void racingStart(Racing racing) {
        proceedRace(racing);
        calculateWinners(racing);
    }

    private void proceedRace(Racing racing) {
        outputView.printRoundResultIntroduceMessage();
        while (racing.getRacingCount() > RACE_END_COUNT) {
            proceedRound(racing);
        }
    }

    private void proceedRound(Racing racing) {
        for (Car car : racing.getCars()) {
            car.move(numberGenerator.generateNumber());
        }

        outputView.printRoundResult(racing);
        racing.deductCount();
    }

    private void calculateWinners(Racing racing) {
        List<String> winnerNames = racing.calculateWinners();
        outputView.printResult(winnerNames);
    }

    private String inputRaceCount() {
        return inputView.inputRaceCount();
    }

    private RacingCount getRaceCount(String inputRaceCount) {
        return RacingCount.from(inputRaceCount);
    }

    private String inputCarName() {
        return inputView.inputCarName();
    }

    private Cars getCars(String input) {
        return Cars.from(input);
    }
}
