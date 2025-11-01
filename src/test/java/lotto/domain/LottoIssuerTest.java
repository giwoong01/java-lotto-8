package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import lotto.domain.generator.FixedLottoGenerator;
import lotto.domain.generator.LottoGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoIssuerTest {

    @DisplayName("lssue() 메소드가 구입 금액에 맞게 로또를 생성합니다.")
    @Test
    void issue_메소드_구입_금액_맞게_로또_생성() {
        // given
        PurchaseAmount purchaseAmount = new PurchaseAmount("8000");
        LottoGenerator lottoGenerator = new FixedLottoGenerator();
        LottoIssuer lottoIssuer = new LottoIssuer(lottoGenerator);

        // when
        Lottos lottos = lottoIssuer.issue(purchaseAmount);

        // then
        assertThat(lottos.getCount()).isEqualTo(8);
    }

}