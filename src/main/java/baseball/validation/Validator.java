package baseball.validation;

public interface Validator {

    String ERROR_MESSAGE = "잘못된 값을 입력하셨습니다.";

    void checkLength(String input);
}
