package baseball.validation;

public class ValidatorImpl implements Validator{

    @Override
    public void checkLength(String input) {
        if (input.length() != 3) {
            throw new IllegalArgumentException(ERROR_MESSAGE);
        }
    }
}
