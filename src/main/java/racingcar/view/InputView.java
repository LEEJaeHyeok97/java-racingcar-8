package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public static final String INPUT_CAR_NAME_PROMPT_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    public static final String INPUT_RACE_COUNT = "시도할 횟수는 몇 회인가요?";

    public String inputCarName() {
        System.out.println(INPUT_CAR_NAME_PROMPT_MESSAGE);

        return Console.readLine();
    }

    public String inputRaceCount() {
        System.out.println(INPUT_RACE_COUNT);

        return Console.readLine();
    }
}
