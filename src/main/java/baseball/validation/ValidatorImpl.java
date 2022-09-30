package baseball.validation;

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
}
