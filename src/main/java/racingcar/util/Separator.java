package racingcar.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Separator {

    public static final String CONTINOUS_DELIMITER_REGEX = ".*,{2,}.*";
    public static final Pattern CONTINUOUS_DELIMITER_PATTERN = Pattern.compile(CONTINOUS_DELIMITER_REGEX);

    public String[] splitNames(String input) {
        validateContinuousDelimiter(input);

        return input.split(input);
    }

    private void validateContinuousDelimiter(String input) {
        Matcher matcher = getContinuousDelimiterMatcher(input);

        if (matcher.matches()) {
            throw new IllegalArgumentException("구분자가 연속으로 입력되었습니다.");
        }
    }

    private Matcher getContinuousDelimiterMatcher(String input) {
        return CONTINUOUS_DELIMITER_PATTERN.matcher(input);
    }
}
