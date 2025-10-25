package racingcar.view;

import racingcar.model.Car;
import racingcar.model.Cars;
import racingcar.model.Racing;

public class OutputView {

    public static final String RESULT_MESSAGE = "최종 우승자 : ";
    public static final String ROUND_RESULT_MESSAGE = "실행 결과";

    public void printResult(String result) {
        System.out.println(RESULT_MESSAGE + result);
    }

    public void printRoundResultMessage() {
        System.out.println(ROUND_RESULT_MESSAGE);
    }

    public void printRoundResult(Racing racing) {
        Cars cars = racing.getRoundResult();

        for (Car car : cars.getCars()) {
            System.out.println(car.getName() + " : " + "-".repeat(car.getCurrentPosition()));
        }

        System.out.println();
    }
}
