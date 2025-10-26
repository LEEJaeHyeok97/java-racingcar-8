package racingcar.exception;

public enum ErrorMessage {
    CAR_NAME_CONTAINS_WHITESPACE("자동차의 이름에 공백이 포함될 수 없습니다."),
    CAR_NAME_LENGTH_EXCEEDED("자동차의 이름의 길이는 5를 초과할 수 없습니다."),
    CAR_NAME_EMPTY("자동차의 이름은 공백이 될 수 없습니다."),
    CAR_NAME_DUPLICATED("같은 자동차의 이름을 중복으로 입력할 수 없습니다."),
    RACE_COUNT_EMPTY("경주 시도 횟수는 공백이 될 수 없습니다."),
    RACE_COUNT_NOT_NUMBER("경주 시도 횟수에 문자를 입력할 수 없습니다."),
    RACE_COUNT_BELOW_MINIMUM("경주 시도 횟수는 1 이상의 정수로 입력해야 합니다."),
    CONTINUOUS_DELIMITER("구분자가 연속으로 입력되었습니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
