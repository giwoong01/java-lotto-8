package lotto.controller;

import java.util.Map;
import lotto.domain.BonusNumber;
import lotto.domain.LottoIssuer;
import lotto.domain.LottoRank;
import lotto.domain.LottoResult;
import lotto.domain.Lottos;
import lotto.domain.PurchaseAmount;
import lotto.domain.WinningLotto;
import lotto.domain.WinningNumbers;
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
        PurchaseAmount purchaseAmount = getPurchaseAmount();
        Lottos lottos = purchaseLottos(purchaseAmount);
        WinningLotto winningLotto = setUpWinningLotto();

        Map<LottoRank, Integer> statistics = lottos.calculateStatistics(winningLotto);

        LottoResult lottoResult = new LottoResult(statistics);
        outputView.printWinningStatistics(lottoResult);
        outputView.printProfitRate(lottoResult.calculateProfitRate(purchaseAmount));
    }

    private Lottos purchaseLottos(PurchaseAmount purchaseAmount) {
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

    private WinningNumbers getWinningNumbers() {
        while (true) {
            try {
                String inputWinningNumbers = inputView.inputWinningNumbers();
                return new WinningNumbers(inputWinningNumbers);
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e.getMessage());
            }
        }
    }

    private BonusNumber getBonusNumber(WinningNumbers winningNumbers) {
        while (true) {
            try {
                String inputBonusNumber = inputView.inputBonusNumber();
                return new BonusNumber(inputBonusNumber, winningNumbers);
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e.getMessage());
            }
        }
    }

    private WinningLotto setUpWinningLotto() {
        WinningNumbers winningNumbers = getWinningNumbers();
        BonusNumber bonusNumber = getBonusNumber(winningNumbers);
        return new WinningLotto(winningNumbers, bonusNumber);
    }

}
