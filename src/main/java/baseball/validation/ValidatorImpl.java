package baseball.validation;

import java.util.Arrays;
import java.util.regex.Pattern;

public class ValidatorImpl implements Validator {

    @Override
    public void checkLength(String input) {
        if (input.length() != LIMIT_LENGTH) {
            throw new IllegalArgumentException(ERROR_MESSAGE);
        }
    }

    @Override
    public void checkRange(String input) {
        String regex = "^[1-9][1-9][1-9]$";
        if (!Pattern.matches(regex, input)) {
            throw new IllegalArgumentException(ERROR_MESSAGE);
        }
    }

    @Override
    public void checkDifferentNumber(String input) {
        String[] split = input.split("");
        int[] sort = new int[LIMIT_LENGTH];
        for (int i = 0; i < LIMIT_LENGTH; i++) {
            sort[i] = Integer.parseInt(split[i]);
        }
        Arrays.sort(sort);
        for (int i = 0; i < LIMIT_LENGTH - 1; i++) {
            isFindSameNumberThenThrow(sort, i);
        }
    }

    private void isFindSameNumberThenThrow(int[] sort, int i) {
        if (sort[i] == sort[i + 1]) {
            throw new IllegalArgumentException(ERROR_MESSAGE);
        }
    }
}
