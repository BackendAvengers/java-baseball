package baseball.domain.dto;

import baseball.domain.entity.Numbers;
import baseball.util.StringUtil;
import java.util.Arrays;
import java.util.List;

public class NumbersMapper {
    public static Numbers toNumbers(String input) {
        String deleteSpaces = StringUtil.removeAllSpaces(input);

        List<Integer> converted = Arrays.stream(input.split(","))
                .map(Integer::parseInt)
                .toList();

        return Numbers.create(converted);
    }

}
