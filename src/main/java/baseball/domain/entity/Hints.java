package baseball.domain.entity;


import static baseball.constants.IntegerConstants.END_CONDITION_STRIKE_COUNT;

public class Hints {
    private final Ball ball;
    private final Strike strike;
    private final Nothing nothing;

    public Hints(Ball ball, Strike strike, Nothing nothing) {
        this.ball = ball;
        this.strike = strike;
        this.nothing = nothing;
    }

    public boolean ismeetingEndConditions() {
        if (strike.isSameCount(END_CONDITION_STRIKE_COUNT.getValue())) {
            return true;
        }
        return false;
    }

    public Ball getBall() {
        return ball;
    }

    public Strike getStrike() {
        return strike;
    }

    public Nothing getNothing() {
        return nothing;
    }
}
