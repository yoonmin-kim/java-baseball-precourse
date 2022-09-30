package baseball.validation;

import static org.assertj.core.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

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
        assertThatIllegalArgumentException().isThrownBy(() -> validator.checkLength(ex));
        assertThatNoException().isThrownBy(() -> validator.checkLength(success));
    }

}