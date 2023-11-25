package baseball.domain.entity;

import baseball.util.ExceptionUtil;
import java.util.Arrays;

public enum Regame {
    REGAME(1),
    EXIT(2);

    private final int number;

    Regame(int number) {
        this.number = number;
    }

    public static Regame findRegame(int number) {
        return Arrays.stream(Regame.values())
                .filter( regame -> number == regame.number)
                .findAny()
                .orElseThrow(() -> ExceptionUtil.returnInvalidValueException());
    }

    public boolean askRegame() {
        if (this.number == REGAME.number) {
            return true;
        }
        return false;
    }

}
