package lotto.view;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Map;
import lotto.domain.LottoRank;
import lotto.domain.LottoResult;
import lotto.domain.Lottos;

public class OutputView {

    private static final String OUTPUT_MESSAGE_PURCHASE_COUNT = "\n%d개를 구매했습니다.\n";
    private static final String STATISTICS_HEADER = "\n당첨 통계";
    private static final String SEPARATOR = "---";
    private static final String STATISTICS_FORMAT = "%s (%s원) - %d개\n";
    private static final String OUTPUT_MESSAGE_PROFIT_RATE_FORMAT = "총 수익률은 %.1f%%입니다.\n";

    public void printErrorMessage(String message) {
        System.out.println(message);
    }

    public void printPurchasedLottos(Lottos lottos) {
        System.out.printf(OUTPUT_MESSAGE_PURCHASE_COUNT, lottos.getCount());
        lottos.getLottos().forEach(lotto -> System.out.println(lotto.getNumbers()));
    }

    public void printWinningStatistics(LottoResult lottoResult) {
        System.out.println(STATISTICS_HEADER);
        System.out.println(SEPARATOR);

        Map<LottoRank, Integer> statistics = lottoResult.getStatistics();
        Arrays.stream(LottoRank.values())
                .filter(rank -> rank != LottoRank.MISS)
                .sorted((r1, r2) -> Integer.compare(r1.getPrizeMoney(), r2.getPrizeMoney()))
                .forEach(rank -> {
                    String description = rank.getDescription();
                    DecimalFormat formatter = new DecimalFormat("###,###");
                    String prize = formatter.format(rank.getPrizeMoney());
                    int count = statistics.getOrDefault(rank, 0);
                    System.out.printf(STATISTICS_FORMAT, description, prize, count);
                });
    }

    public void printProfitRate(double profitRate) {
        System.out.printf(OUTPUT_MESSAGE_PROFIT_RATE_FORMAT, profitRate);
    }

}
