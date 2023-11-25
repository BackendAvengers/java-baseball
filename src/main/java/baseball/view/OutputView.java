package baseball.view;

import static baseball.messages.OutputMessages.MEETING_END_CONDITIONS;

public class OutputView {
    public void outputEndMessage() {
        System.out.println(MEETING_END_CONDITIONS.getMessage());
    }
}
