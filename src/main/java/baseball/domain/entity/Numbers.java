package baseball.domain.entity;

import static baseball.constants.IntegerConstants.NUMBERS_LENGTH;
import static baseball.constants.IntegerConstants.NUMBERS_MAX_RANGE;
import static baseball.constants.IntegerConstants.NUMBERS_MIN_RAGNE;

import baseball.util.ExceptionUtil;
import baseball.util.RandomUtil;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Numbers {
    private final List<Integer> numbers;

    private Numbers(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public static Numbers create(List<Integer> numbers) {
        return new Numbers(numbers);
    }

    public static Numbers createRandom() {
        List<Integer> generated = RandomUtil.pickRandomNumbers(
                NUMBERS_LENGTH.getValue(),
                NUMBERS_MIN_RAGNE.getValue(),
                NUMBERS_MAX_RANGE.getValue());

        return new Numbers(generated);
    }

    private void validate(List<Integer> numbers) {
        validateLength(numbers);
        validateDuplicate(numbers);
        validateNumberInRange(numbers);
    }

    private void validateNumberInRange(List<Integer> numbers) {
        boolean isInRange = numbers.stream()
                .allMatch(number
                        -> (number >= NUMBERS_MIN_RAGNE.getValue()
                        && number <= NUMBERS_MAX_RANGE.getValue()));

        if (!isInRange) {
            ExceptionUtil.throwInvalidValueException();
        }
    }

    private void validateDuplicate(List<Integer> numbers) {
        Set<Integer> removeDuplicate = numbers
                .stream()
                .collect(Collectors.toSet());

        if (removeDuplicate.size() != numbers.size()) {
            ExceptionUtil.throwInvalidValueException();
        }
    }

    private void validateLength(List<Integer> numbers) {
        if (numbers.size() != NUMBERS_LENGTH.getValue()) {
            ExceptionUtil.throwInvalidValueException();
        }
    }


}
