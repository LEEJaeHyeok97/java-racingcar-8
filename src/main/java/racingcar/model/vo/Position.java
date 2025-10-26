package racingcar.model.vo;

public class Position {

    public static final int MOVE_THRESHOLD = 4;
    public static final int MOVE_DISTANCE = 1;
    private int position;

    public Position(int position) {
        this.position = position;
    }

    public int getPosition() {
        return position;
    }

    public static Position of(int position) {
        return new Position(position);
    }

    public void move(int randomNumber) {
        if (isMovable(randomNumber)) {
            position += MOVE_DISTANCE;
        }
    }

    private boolean isMovable(int randomNumber) {
        return randomNumber >= MOVE_THRESHOLD;
    }
}
