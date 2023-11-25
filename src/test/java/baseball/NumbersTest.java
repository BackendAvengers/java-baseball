package baseball;

import baseball.domain.entity.Numbers;
import org.junit.jupiter.api.Test;

import static baseball.constants.IntegerConstants.NUMBERS_LENGTH;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;
import java.util.List;

public class NumbersTest {

    @Test
    public void testCreateNumbers() {
        List<Integer> inputNumbers = Arrays.asList(1, 2, 3);
        Numbers numbers = Numbers.create(inputNumbers);
        assertNotNull(numbers);
        assertEquals(3, numbers.getSize());
    }

    @Test
    public void testCreateRandomNumbers() {
        Numbers numbers = Numbers.createRandom();
        assertNotNull(numbers);
        assertEquals(NUMBERS_LENGTH.getValue(), numbers.getSize());
    }

    @Test
    public void testCountSameValueAndSamePlace() {
        Numbers numbers1 = Numbers.create(Arrays.asList(1, 2, 3));
        Numbers numbers2 = Numbers.create(Arrays.asList(1, 4, 3));
        int count = numbers1.countSameValueAndSamePlace(numbers2);
        assertEquals(2, count);
    }

    @Test
    public void testCountSameValueAndDifferentPlace() {
        Numbers numbers1 = Numbers.create(Arrays.asList(4, 5, 6));
        Numbers numbers2 = Numbers.create(Arrays.asList(5, 4, 7));
        int count = numbers1.countSameValueAndDifferentPlace(numbers2);
        assertEquals(2, count);
    }

    @Test
    public void testInvalidNumbersLength() {
        List<Integer> inputNumbers = Arrays.asList(1, 2); // Invalid length

        assertThatThrownBy(() -> Numbers.create(inputNumbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

}
