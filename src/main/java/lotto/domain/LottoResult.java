package lotto.domain;

import java.util.Map;

public class LottoResult {

    private final Map<LottoRank, Integer> statistics;

    public LottoResult(Map<LottoRank, Integer> statistics) {
        this.statistics = statistics;
    }

    public double calculateProfitRate(PurchaseAmount purchaseAmount) {
        long totalPrize = calculateTotalPrize();
        if (totalPrize == 0) {
            return 0.0;
        }
        return (double) totalPrize / purchaseAmount.getValue() * 100;
    }

    private long calculateTotalPrize() {
        return statistics.entrySet().stream()
                .mapToLong(entry -> (long) entry.getKey().getPrizeMoney() * entry.getValue())
                .sum();
    }

    public Map<LottoRank, Integer> getStatistics() {
        return statistics;
    }
}