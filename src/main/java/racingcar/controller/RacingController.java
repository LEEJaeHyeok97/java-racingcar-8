package racingcar.controller;

import java.util.List;
import racingcar.model.Cars;
import racingcar.model.Racing;
import racingcar.model.vo.RacingCount;
import racingcar.util.NumberGenerator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingController {

    private final InputView inputView;
    private final OutputView outputView;
    private final NumberGenerator numberGenerator;

    public RacingController(InputView inputView, OutputView outputView, NumberGenerator numberGenerator) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.numberGenerator = numberGenerator;
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
        while (racing.hasNextRound()) {
            racing.proceedOneRound(numberGenerator);
            outputView.printRoundResult(racing);
        }
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
