package baseball.util;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class RandomUtil {

    public static List<Integer> pickRandomNumbers(int size, int minRange, int maxRange) {
        List<Integer> computer = new ArrayList<>();

        while (computer.size() < size) {
            int randomNumber = Randoms.pickNumberInRange(minRange, maxRange);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }

        return computer;
    }
}
