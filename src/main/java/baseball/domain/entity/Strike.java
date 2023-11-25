package baseball.domain.entity;

public class Strike {
    private final int count;

    public Strike(int count) {
        this.count = count;
    }

    public boolean isActivate() {
        return count>0;
    }

    public boolean isSameCount(int value) {
        return count==value;
    }

    public int getCount() {
        return count;
    }
}
