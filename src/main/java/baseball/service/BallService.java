package baseball.service;

import baseball.domain.entity.Ball;
import baseball.domain.entity.Numbers;

public class BallService {

    public Ball createBall(Numbers UserNumbers, Numbers computerNumbers) {
        int ballCount = UserNumbers.countSameValueAndSamePlace(computerNumbers);

        return new Ball(ballCount);
    }
}
