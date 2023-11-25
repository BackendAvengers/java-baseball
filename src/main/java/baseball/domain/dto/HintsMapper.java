package baseball.domain.dto;

import baseball.domain.entity.Hints;

public class HintsMapper {

    public static HintsDto of(Hints hints) {
        int ballCount = hints.getBall().getCount();
        int strikeCount = hints.getStrike().getCount();
        boolean isNothing = hints.getNothing().isActivation();

        return new HintsDto(ballCount, strikeCount, isNothing);
    }
}
