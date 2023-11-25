package baseball.view;

import static baseball.messages.InputMessages.INPUT_NUMBERS;
import static baseball.messages.InputMessages.START_INPUT;

import baseball.domain.dto.NumbersMapper;
import baseball.domain.entity.Numbers;
import baseball.util.InputUtil;

public class InputView {

    public void start() {
        System.out.println(START_INPUT);
    }

    public Numbers inputNumbers() {
        System.out.print(INPUT_NUMBERS.getMessage());
        String input = InputUtil.input();
        return NumbersMapper.toNumbers(input);
    }
}
