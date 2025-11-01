package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class PurchaseAmountTest {

    @DisplayName("정상 구입 금액 객체를 생성합니다.")
    @Test
    void 정상_구입_금액_객체_생성() {
        // given
        String input = "8000";

        // when & then
        assertDoesNotThrow(() -> new PurchaseAmount(input));
    }

    @DisplayName("구입 금액에 맞는 로또 개수를 정상 반환합니다.")
    @Test
    void 구입_금액_로또_개수_정상_반환() {
        // given
        PurchaseAmount purchaseAmount = new PurchaseAmount("8000");

        // when
        int lottoCount = purchaseAmount.calculateLottoCount();

        // then
        assertThat(lottoCount).isEqualTo(8);
    }

    @DisplayName("구입 금액이 1000원 단위가 아닌 경우 예외가 발생합니다.")
    @Test
    void 구입_금액_단위_불일치_예외_발생() {
        // given
        String input = "8500";

        // when & then
        assertThatThrownBy(() -> new PurchaseAmount(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구입 금액이 0 또는 음수인 경우 예외가 발생합니다.")
    @ParameterizedTest
    @ValueSource(strings = {"0", "-1000"})
    void 구입_금액_0_또는_음수_예외_발생(String input) {
        // when & then
        assertThatThrownBy(() -> new PurchaseAmount(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구입 금액이 숫자가 아닌 문자나 공백일 경우 예외가 발생합니다.")
    @ParameterizedTest
    @ValueSource(strings = {"a", "1000 "})
    void 구입_금액_숫자X_문자_공백_예외_발생(String input) {
        // when & then
        assertThatThrownBy(() -> new PurchaseAmount(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

}