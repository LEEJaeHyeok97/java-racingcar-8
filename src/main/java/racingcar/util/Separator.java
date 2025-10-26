package racingcar.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import racingcar.exception.ErrorMessage;

public class Separator {

    public static final String CONTINUOUS_DELIMITER_REGEX = ",{2,}";
    public static final Pattern CONTINUOUS_DELIMITER_PATTERN = Pattern.compile(CONTINUOUS_DELIMITER_REGEX);
    public static final String DELIMITER = ",";

    public static String[] splitNames(String input) {
        validateContinuousDelimiter(input);

        return input.split(DELIMITER);
    }

    private static void validateContinuousDelimiter(String input) {
        Matcher matcher = getContinuousDelimiterMatcher(input);

        if (matcher.find()) {
            throw new IllegalArgumentException(ErrorMessage.CONTINUOUS_DELIMITER.getMessage());
        }
    }

    private static Matcher getContinuousDelimiterMatcher(String input) {
        return CONTINUOUS_DELIMITER_PATTERN.matcher(input);
    }
}
