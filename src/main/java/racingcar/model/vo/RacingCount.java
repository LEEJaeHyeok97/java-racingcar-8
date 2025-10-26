package racingcar.model.vo;

import racingcar.exception.ErrorMessage;

public class RacingCount {

    public static final int MIN_RACE_COUNT = 1;
    public static final int ONE_ATTEMPT = 1;
    private int count;

    public RacingCount(int count) {
        this.count = count;
    }

    public void deductCount() {
        count -= ONE_ATTEMPT;
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
            throw new IllegalArgumentException(ErrorMessage.RACE_COUNT_EMPTY.getMessage());
        }
    }

    private static int parseInteger(String racingCount) {
        try {
            return Integer.parseInt(racingCount);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException(ErrorMessage.RACE_COUNT_NOT_NUMBER.getMessage());
        }
    }

    private static void validateMinRaceCount(int parsedLong) {
        if (parsedLong < MIN_RACE_COUNT) {
            throw new IllegalArgumentException(ErrorMessage.RACE_COUNT_BELOW_MINIMUM.getMessage());
        }
    }
}
