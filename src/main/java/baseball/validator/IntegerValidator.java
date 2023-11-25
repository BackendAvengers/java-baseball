package baseball.validator;

import baseball.util.ExceptionUtil;
import baseball.util.IntegerUtil;

public class IntegerValidator {

    public static void validateInteger(String input) {
        if (!IntegerUtil.isInteger(input)) {
            ExceptionUtil.throwInvalidValueException();
        }
    }
}
