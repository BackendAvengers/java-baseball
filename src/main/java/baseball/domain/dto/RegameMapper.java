package baseball.domain.dto;

import baseball.domain.entity.Regame;
import baseball.util.StringUtil;
import baseball.validator.IntegerValidator;

public class RegameMapper {
    public static Regame toRegame(String input) {
        String deleteSpaces = StringUtil.removeAllSpaces(input);
        IntegerValidator.validateInteger(input);
        int converted = Integer.parseInt(deleteSpaces);

        return Regame.findRegame(converted);
    }
}
