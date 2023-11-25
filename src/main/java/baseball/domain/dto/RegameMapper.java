package baseball.domain.dto;

import baseball.domain.entity.Regame;
import baseball.util.StringUtil;

public class RegameMapper {
    public static Regame toRegame(String input) {
        String deleteSpaces = StringUtil.removeAllSpaces(input);
        int converted = Integer.parseInt(deleteSpaces);

        return Regame.findRegame(converted);
    }
}
