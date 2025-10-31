package lotto;

import camp.nextstep.edu.missionutils.Console;
import lotto.controller.LottoController;
import lotto.domain.LottoIssuer;
import lotto.domain.generator.RandomLottoGenerator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Application {
    public static void main(String[] args) {
        try {
            InputView inputView = new InputView();
            OutputView outputView = new OutputView();
            LottoIssuer lottoIssuer = new LottoIssuer(new RandomLottoGenerator());

            LottoController lottoController = new LottoController(inputView, outputView, lottoIssuer);

            lottoController.run();
        } finally {
            Console.close();
        }
    }
}
