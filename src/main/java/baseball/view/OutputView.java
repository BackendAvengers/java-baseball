package baseball.view;

import static baseball.messages.OutputMessages.BALL;
import static baseball.messages.OutputMessages.MEETING_END_CONDITIONS;
import static baseball.messages.OutputMessages.NOTHING;
import static baseball.messages.OutputMessages.START_INPUT;
import static baseball.messages.OutputMessages.STRIKE;

import baseball.domain.dto.HintsDto;
import baseball.util.StringUtil;

public class OutputView {

    public void start() {
        System.out.println(START_INPUT.getMessage());
    }


    public void outputHints(HintsDto hintsDto) {
        int ballCount = hintsDto.ballCount();
        int strikeCount = hintsDto.strikeCount();
        boolean isNothing = hintsDto.isNothing();
        System.out.println(ballCount+ " " + strikeCount + " " +isNothing);
        String result = StringUtil.joinNonEmptyStrings(" ",
                makeBallFormat(ballCount),
                makeStrikeFormat(strikeCount),
                makeNothingFormat(isNothing));

        System.out.println(result.trim());
    }

    public void outputEndMessage() {
        System.out.println(MEETING_END_CONDITIONS.getMessage());
    }

    private String makeBallFormat(int ballCount) {
        if (ballCount > 0) {
            return ballCount + BALL.getMessage();
        }
        return "";
    }

    private String makeStrikeFormat(int strikeCount) {
        if (strikeCount > 0 ){
            return strikeCount + STRIKE.getMessage();
        }
        return "";
    }

    private String makeNothingFormat(boolean isNothing) {
        if (isNothing) {
            return NOTHING.getMessage();
        }
        return "";
    }
}
