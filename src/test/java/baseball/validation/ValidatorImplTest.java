package baseball.validation;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.assertThatNoException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class ValidatorImplTest {

    Validator validator;

    @BeforeEach
    void beforeEach() {
        validator = new ValidatorImpl();
    }

    @ParameterizedTest
    @DisplayName("입력 받은 값이 3자리 라면 통과, 아니라면 Ex발생")
    @CsvSource(value = {"1:123"}, delimiter = ':')
    void checkLength(String ex, String success) {
        assertThatIllegalArgumentException().isThrownBy(() -> validator.checkLength(ex))
                .withMessage(Validator.ERROR_MESSAGE);
        assertThatNoException().isThrownBy(() -> validator.checkLength(success));
    }

    @ParameterizedTest
    @DisplayName("입력 받은 값이 1-9 사이에 포함되는가")
    @CsvSource(value = {"1이3:123"}, delimiter = ':')
    void checkRange(String ex, String success) {
        assertThatIllegalArgumentException().isThrownBy(() -> validator.checkRange(ex))
                .withMessage(Validator.ERROR_MESSAGE);
        assertThatNoException().isThrownBy(() -> validator.checkRange(success));
    }

    @ParameterizedTest
    @DisplayName("입력 받은 값이 서로다른 숫자인가")
    @CsvSource(value = {"131:123"}, delimiter = ':')
    void checkDifferentNumber(String ex, String success) {
        assertThatIllegalArgumentException().isThrownBy(() -> validator.checkDifferentNumber(ex))
                .withMessage(Validator.ERROR_MESSAGE);
        assertThatNoException().isThrownBy(() -> validator.checkDifferentNumber(success));
    }
}