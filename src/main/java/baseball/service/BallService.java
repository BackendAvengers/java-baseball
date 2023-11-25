package baseball.service;

import baseball.domain.entity.Ball;
import baseball.domain.entity.Numbers;

public class BallService {

    public Ball createBall(Numbers userNumbers, Numbers computerNumbers) {
        int ballCount = userNumbers.countSameValueAndDifferentPlace(computerNumbers);

        return new Ball(ballCount);
    }
}
