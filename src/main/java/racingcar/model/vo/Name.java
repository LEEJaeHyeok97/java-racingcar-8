package racingcar.model.vo;

import java.util.Objects;
import racingcar.exception.ErrorMessage;

public class Name {

    public static final int MAX_LENGTH_LIMIT = 5;
    public static final String WHITE_SPACE = " ";
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
        if (name.contains(WHITE_SPACE)) {
            throw new IllegalArgumentException(ErrorMessage.CAR_NAME_CONTAINS_WHITESPACE.getMessage());
        }
    }

    private static void validateIsMaxLength(String name) {
        if (name.length() > MAX_LENGTH_LIMIT) {
            throw new IllegalArgumentException(ErrorMessage.CAR_NAME_LENGTH_EXCEEDED.getMessage());
        }
    }

    private void validateIsEmpty(String name) {
        if (name.isEmpty()) {
            throw new IllegalArgumentException(ErrorMessage.CAR_NAME_EMPTY.getMessage());
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
