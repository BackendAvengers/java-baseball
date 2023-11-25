package baseball.domain.entity;

import java.util.List;

public class Numbers {
    private final List<Integer> numbers;

    private Numbers(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public static Numbers create(List<Integer> numbers) {
        return new Numbers(numbers);
    }

    private void validate(List<Integer> numbers) {

    }

}
