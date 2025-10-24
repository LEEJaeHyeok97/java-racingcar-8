package racingcar.model.vo;

public class Name {

    public static final int MAX_LENGTH_LIMIT = 5;
    private final String name;

    public Name(String name) {
        validate(name);
        this.name = name;
    }

    private void validate(String name) {
        validateisEmpty(name);
        validateIsMaxLength(name);
    }

    private static void validateIsMaxLength(String name) {
        if (name.length() > MAX_LENGTH_LIMIT) {
            throw new IllegalArgumentException("자동차의 이름의 길이는 5를 초과할 수 없습니다.");
        }
    }

    private void validateisEmpty(String name) {
        if (name.isEmpty()) {
            throw new IllegalArgumentException("자동차의 이름은 공백이 될 수 없습니다.");
        }
    }

    public String getName() {
        return name;
    }
}
