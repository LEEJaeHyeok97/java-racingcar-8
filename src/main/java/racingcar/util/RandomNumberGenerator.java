package racingcar.util;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumberGenerator implements NumberGenerator {

    public static final int MIN_NUMBER = 0;
    public static final int MAX_NUMBER = 9;

    @Override
    public int generateNumber() {
        return Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER);
    }
}
