package baseball.domain.entity;

public class Nothing {
    private final boolean activation;

    private Nothing(boolean activation) {
        this.activation = activation;
    }

    public static Nothing createActivated() {
        return new Nothing(true);
    }

    public static Nothing createNotActivated() {
        return new Nothing(false);
    }

    public boolean isActivation() {
        return activation;
    }
}
