package baseball.validator;

import baseball.util.ExceptionUtil;
import baseball.util.IntegerUtil;
import java.util.List;

public class IntegerListValidator {

    public static void validateInteger(List<String> separated) {
        boolean result = separated
                .stream()
                .allMatch( value -> IntegerUtil.isInteger(value));

        if (!result) {
            ExceptionUtil.throwInvalidValueException();
        }
    }
}
