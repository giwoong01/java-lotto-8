package lotto.controller;

import lotto.domain.LottoIssuer;
import lotto.domain.Lottos;
import lotto.domain.PurchaseAmount;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    private final InputView inputView;
    private final OutputView outputView;
    private final LottoIssuer lottoIssuer;

    public LottoController(InputView inputView, OutputView outputView, LottoIssuer lottoIssuer) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.lottoIssuer = lottoIssuer;
    }

    public void run() {
        Lottos lottos = purchaseLottos();

    }

    private Lottos purchaseLottos() {
        PurchaseAmount purchaseAmount = getPurchaseAmount();
        Lottos lottos = lottoIssuer.issue(purchaseAmount);
        outputView.printPurchasedLottos(lottos);
        return lottos;
    }

    private PurchaseAmount getPurchaseAmount() {
        while (true) {
            try {
                String inputPurchaseAmount = inputView.inputPurchaseAmount();
                return new PurchaseAmount(inputPurchaseAmount);
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e.getMessage());
            }
        }
    }

}
