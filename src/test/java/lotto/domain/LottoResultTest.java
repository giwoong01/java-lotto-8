package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.EnumMap;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoResultTest {

    @DisplayName("calculateProfitRate() 메소드가 총 상금과 구입 금액을 바탕으로 수익률을 정상으로 계산합니다.")
    @Test
    void calculateProfitRate_메소드_총_상금_구입_금액_바탕으로_수익률_정상_계산() {
        // given
        PurchaseAmount purchaseAmount = new PurchaseAmount("8000");
        Map<LottoRank, Integer> statistics = new EnumMap<>(LottoRank.class);
        statistics.put(LottoRank.FIFTH, 1);
        LottoResult lottoResult = new LottoResult(statistics);

        // when
        double profitRate = lottoResult.calculateProfitRate(purchaseAmount);

        // then
        assertThat(profitRate).isEqualTo(62.5);
    }

    @DisplayName("당첨금이 0일 경우 수익률 0.0을 반환합니다.")
    @Test
    void 당첨금_0_수익률_반환() {
        // given
        PurchaseAmount purchaseAmount = new PurchaseAmount("8000");
        Map<LottoRank, Integer> statistics = new EnumMap<>(LottoRank.class);
        statistics.put(LottoRank.MISS, 1);
        LottoResult lottoResult = new LottoResult(statistics);

        // when
        double profitRate = lottoResult.calculateProfitRate(purchaseAmount);

        // then
        assertThat(profitRate).isEqualTo(0.0);
    }

}