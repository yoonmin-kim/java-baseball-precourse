package baseball.domain.result;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class ResultTest {

    private static final String NOTHING = State.NOTHING.getDescription();
    private static final String STRIKE = State.STRIKE.getDescription();
    Result result = new DefaultResult();

    @Test
    @DisplayName("기본 결과는 낫싱")
    void isNothing() {
        assertThat(result.result()).isEqualTo(NOTHING);
    }

    @ParameterizedTest
    @DisplayName("1,2,3 스트라이크")
    @ValueSource(ints = {1, 2, 3})
    void strike(int strike) {
        result = new StrikeResult(result);
        result.setStrike(strike);
        assertThat(result.result()).isEqualTo(strike + STRIKE);
    }

}