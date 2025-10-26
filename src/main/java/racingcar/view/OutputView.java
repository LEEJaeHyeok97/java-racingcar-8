package racingcar.view;

import java.util.List;
import racingcar.model.Car;
import racingcar.model.Cars;
import racingcar.model.Racing;

public class OutputView {

    public static final String LINE_SEPARATOR = System.lineSeparator();
    public static final String RESULT_MESSAGE = "최종 우승자 : ";
    public static final String ROUND_RESULT_MESSAGE = LINE_SEPARATOR + "실행 결과";

    public void printResult(List<String> input) {
        String result = String.join(", ", input);
        System.out.println(RESULT_MESSAGE + result);
    }

    public void printRoundResultIntroduceMessage() {
        System.out.println(ROUND_RESULT_MESSAGE);
    }

    public void printRoundResult(Racing racing) {
        Cars cars = racing.getRoundResult();

        for (Car car : cars) {
            System.out.println(car.getName() + " : " + "-".repeat(car.getCurrentPosition()));
        }

        System.out.println();
    }
}
