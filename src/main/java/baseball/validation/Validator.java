package baseball.validation;

public interface Validator {

    int LIMIT_LENGTH = 3;
    String ERROR_MESSAGE = "서로다른 " + LIMIT_LENGTH + "자리 수를 입력해주세요.";

    void checkLength(String input);

    void checkRange(String input);

    void checkDifferentNumber(String input);
}
