package lotto.message;

public enum ErrorMessage {

    PURCHASE_AMOUNT_NOT_A_NUMBER("구입 금액을 다시 입력해주세요. (문자나 공백이면 안됩니다. 양의 정수만 입력해야 합니다.)"),
    PURCHASE_AMOUNT_NOT_POSITIVE("구입 금액을 다시 입력해주세요. (음수나 0이면 안됩니다. 양의 정수만 입력해야 합니다.)"),
    PURCHASE_AMOUNT_INVALID_UNIT("구입 금액을 다시 입력해주세요. (1,000원 단위여야 합니다.)"),

    WINNING_NUMBERS_INVALID_FORMAT("당첨 번호를 다시 입력해주세요. (숫자와 쉼표(,)만 입력해야 합니다.)"),
    WINNING_NUMBERS_INVALID_SIZE("당첨 번호를 다시 입력해주세요. (당첨 번호는 6개여야 합니다.)"),
    WINNING_NUMBERS_INVALID_RANGE("당첨 번호를 다시 입력해주세요. (1부터 45사이의 숫자여야 합니다.)"),
    WINNING_NUMBERS_DUPLICATE("당첨 번호를 다시 입력해주세요. (중복된 숫자를 입력하면 안됩니다.)"),

    LOTTO_INVALID_SIZE("로또 번호는 6개여야 합니다.");


    private static final String PREFIX = "[ERROR] ";

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return PREFIX + message;
    }

}
