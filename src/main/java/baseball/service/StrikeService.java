package baseball.service;

import baseball.domain.entity.Numbers;
import baseball.domain.entity.Strike;

public class StrikeService {

    public Strike createStrike(Numbers UserNumbers, Numbers computerNumbers) {
        int strikeCount = UserNumbers.countSameValueAndDifferentPlace(computerNumbers);

        return new Strike(strikeCount);
    }
}
