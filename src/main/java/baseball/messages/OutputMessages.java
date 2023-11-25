package baseball.messages;

import static baseball.constants.IntegerConstants.END_CONDITION_STRIKE_COUNT;

public enum OutputMessages {

    START_INPUT("숫자 야구 게임을 시작합니다."),
    MEETING_END_CONDITIONS(String.format(
            "%d개의 숫자를 모두 맞히셨습니다! 게임 종료", END_CONDITION_STRIKE_COUNT.getValue())),
    BALL("볼"),
    STRIKE("스트라이크"),
    NOTHING("낫싱");

    private final String message;

    OutputMessages(final String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
