package baseball.domain.entity;

public class Ball {
    private final int count;

    public Ball(int count) {
        this.count = count;
    }

    public boolean isActivate() {
        return count>0;
    }
}
