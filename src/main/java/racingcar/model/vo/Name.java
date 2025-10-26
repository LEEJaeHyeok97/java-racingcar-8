package racingcar.model.vo;

import java.util.Objects;
import java.util.regex.Pattern;

public class Name {

    public static final int MAX_LENGTH_LIMIT = 5;
    private final String name;

    public Name(String name) {
        validate(name);
        this.name = name;
    }

    public static Name of(String name) {
        return new Name(name);
    }

    private void validate(String name) {
        validateContainsWhiteSpace(name);
        validateIsEmpty(name);
        validateIsMaxLength(name);
    }

    private static void validateContainsWhiteSpace(String name) {
        if (name.contains(" ")) {
            throw new IllegalArgumentException("자동차의 이름에 공백이 포함될 수 없습니다.");
        }
    }

    private static void validateIsMaxLength(String name) {
        if (name.length() > MAX_LENGTH_LIMIT) {
            throw new IllegalArgumentException("자동차의 이름의 길이는 5를 초과할 수 없습니다.");
        }
    }

    private void validateIsEmpty(String name) {
        if (name.isEmpty()) {
            throw new IllegalArgumentException("자동차의 이름은 공백이 될 수 없습니다.");
        }
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof Name)) {
            return false;
        }
        Name objectName = (Name) object;
        return Objects.equals(name, objectName.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
