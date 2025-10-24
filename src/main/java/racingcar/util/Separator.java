package racingcar.util;

public class Separator {

    public static final String DELIMITER = ",";

    public String[] splitNames(String input) {
        return input.split(DELIMITER);
    }
}
