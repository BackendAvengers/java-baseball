package baseball.domain.entity;

import static baseball.constants.IntegerConstants.NUMBERS_LENGTH;
import static baseball.constants.IntegerConstants.NUMBERS_MAX_RANGE;
import static baseball.constants.IntegerConstants.NUMBERS_MIN_RAGNE;

import baseball.util.ExceptionUtil;
import baseball.util.RandomUtil;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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

    public int countSameValueAndSamePlace(Numbers other) {
        return (int) IntStream.range(0, numbers.size())
                .filter(index -> this.getNumber(index) == other.getNumber(index))
                .count();
    }

    public int countSameValueAndDifferentPlace(Numbers other) {
        return IntStream.range(0, this.getSize())
                .map(i -> countMatchesAtDifferentPlaces(i, other))
                .sum();
    }

    private int countMatchesAtDifferentPlaces(int index, Numbers other) {
        return (int) IntStream.range(0, other.getSize())
                .filter(j -> index != j && this.getNumber(index) == other.getNumber(index))
                .count();
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

    public List<Integer> getNumbers() {
        return numbers;
    }

    public int getSize() {
        return numbers.size();
    }

    public int getNumber(int index) {
        return numbers.get(index);
    }
}
