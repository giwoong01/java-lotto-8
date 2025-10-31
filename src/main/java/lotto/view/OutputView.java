package lotto.view;

import lotto.domain.Lottos;

public class OutputView {

    private static final String OUTPUT_MESSAGE_PURCHASE_COUNT = "\n%d개를 구매했습니다.\n";

    public void printErrorMessage(String message) {
        System.out.println(message);
    }

    public void printPurchasedLottos(Lottos lottos) {
        System.out.printf(OUTPUT_MESSAGE_PURCHASE_COUNT, lottos.getCount());
        lottos.getLottos().forEach(lotto -> System.out.println(lotto.getNumbers()));
    }

}
