package baseball.domain.dto;

import baseball.domain.entity.Numbers;
import baseball.util.StringUtil;
import baseball.validator.IntegerListValidator;
import java.util.Arrays;
import java.util.List;

public class NumbersMapper {
    public static Numbers toNumbers(String input) {
        String deleteSpaces = StringUtil.removeAllSpaces(input);
        List<String> separated = Arrays.stream(input.split(","))
                .toList();

        IntegerListValidator.validateInteger(separated);

        List<Integer> converted = Arrays.stream(input.split(""))
                .map(Integer::parseInt)
                .toList();

        return Numbers.create(converted);
    }

}
