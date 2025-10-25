package racingcar.model.vo;

public class RacingCount {

    public static final int MIN_RACE_COUNT = 1;
    private int count;

    public RacingCount(int count) {
        this.count = count;
    }

    public void deductCount() {
        count--;
    }

    public int getCount() {
        return count;
    }

    public static RacingCount from(String racingCount) {
        int parsedLong = getParsedLong(racingCount);
        validateMinRaceCount(parsedLong);
        return new RacingCount(parsedLong);
    }

    private static int getParsedLong(String racingCount) {
        validateIsEmpty(racingCount);
        return parseInteger(racingCount);
    }

    private static void validateIsEmpty(String racingCount) {
        if (racingCount.isEmpty()) {
            throw new IllegalArgumentException("경주 시도 횟수는 공백이 될 수 없습니다.");
        }
    }

    private static int parseInteger(String racingCount) {
        try {
            return Integer.parseInt(racingCount);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException("경주 시도 횟수에 문자를 입력할 수 없습니다.");
        }
    }

    private static void validateMinRaceCount(int parsedLong) {
        if (parsedLong < MIN_RACE_COUNT) {
            throw new IllegalArgumentException("경주 시도 횟수는 1 이상의 정수로 입력해야 합니다.");
        }
    }
}
