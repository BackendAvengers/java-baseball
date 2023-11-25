package baseball.service;

import baseball.domain.entity.Ball;
import baseball.domain.entity.Nothing;
import baseball.domain.entity.Numbers;
import baseball.domain.entity.Strike;

public class NothingService {
    public Nothing createNothing(Ball ball, Strike strike) {

        if (!ball.isActivate() && !strike.isActivate()) {
            return Nothing.createActivated();
        }

        return Nothing.createNotActivated();
    }
}
