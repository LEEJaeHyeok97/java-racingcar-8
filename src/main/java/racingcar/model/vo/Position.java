package racingcar.model.vo;

public class Position {

    public static final int MOVE_THRESHOLD = 4;
    public static final int MOVE_DISTANCE = 1;
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

    public Position move(int randomNumber) {
        if (isMovable(randomNumber)) {
            return new Position(position + MOVE_DISTANCE);
        }
        return this;
    }

    private boolean isMovable(int randomNumber) {
        return randomNumber >= MOVE_THRESHOLD;
    }
}
