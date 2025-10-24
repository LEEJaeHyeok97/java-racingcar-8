package racingcar.view;

public class OutputView {

    public static final String RESULT_MESSAGE = "최종 우승자 : ";

    public void printResult(String result) {
        System.out.println(RESULT_MESSAGE + result);
    }
}
