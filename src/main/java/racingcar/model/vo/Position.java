package racingcar.model.vo;

public class Position {

    private final int position;

    public Position(int position) {
        this.position = position;
    }

    public int getDistance() {
        return position;
    }

    public static Position of(int position) {
        return new Position(position);
    }
}
