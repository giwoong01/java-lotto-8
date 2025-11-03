# java-lotto-precourse

---

## 기능 요구 사항 정리

간단한 로또 발매기를 구현한다.

- 로또 번호의 숫자 범위는 1 ~ 45까지이다.
- 1개의 로또를 발행할 때 중복되지 않는 6개의 숫자를 뽑는다.
- 당첨 번호 추첨시 중복되지 않는 숫자 6개와 보너스 번호 1개를 뽑는다.ㅐ
- 당첨은 1등부터 5등까지 존재한다.
    - 1등: 6개 번호 일치 / 2,000,000,000원
    - 2등: 5개 번호 + 보너스 번호 일치 / 30,000,000원
    - 3등: 5개 번호 일치 / 1,500,000원
    - 4등: 4개 번호 일치 / 50,000원
    - 5등: 3개 번호 일치 / 5,000원
- 로또 구입 금액을 입력하면 구입 금액에 해당하는 만큼 로또를 발행한다.
- 로또 한 장의 가격은 1,000원이다.
- 당첨 번호와 보너스 번호를 입력받는다.
- 사용자가 구매한 로또 번호와 당첨 번호를 비교하여 당첨 내역 및 수익률을 출력한다.

## 목표

- 1, 2주차 공통 피드백 신경쓰기
- 프로그래밍 요구 사항 잘 지키기
- 스스로 고민하고 생각하기
- 근거있는 코드 작성하기

## 구현할 기능 목록

- [x] 사용자
    - [x] 구입 금액을 입력한다.
        - 단위는 1,000원 단위로 입력한다.
        - 1,000으로 나누어떨어지지 않는 경우 예외 처리한다.
        - 양의 정수값만 입력한다.
    - [x] 당첨 번호를 입력한다.
        - 번호는 쉼표(,) 기준으로 구분한다.
        - 중복되게 입력하지 않는다.
        - 1부터 45사이의 숫자여야한다.
        - 양의 정수값만 입력한다.
    - [x] 보너스 번호를 입력한다.
        - 당첨 번호와 중복되게 입력하지 않는다.
        - 1부터 45사이의 숫자여야한다.
        - 양의 정수값만 입력한다.


- [x] 로또 발행기
    - [x] 로또를 발행한다.
        - 구입 금액을 1,000으로 나눈 몫 만큼 발행 한다.
            - (예: 구입 금액이 8,000원 이면 로또는 8개 발행 한다.)


- [x] 당첨 계산기
    - [x] 발행한 로또 번호와 당첨 번호를 비교하여 당첨 통계를 계산한다.
    - [x] 수익률을 계산한다.
        - 수익률은 소수점 둘째 자리에서 반올림한다.

## 주의할 점

- 예외 상황 시 에러 문구를 출력해야 한다.
    - 에러 문구는 "[ERROR]"로 시작해야 한다.
    - 예) "[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다."
- 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException을 발생시키고 에러 메시지 출력 후 그 부분부터 입력을 다시 받는다.
    - Exception이 아닌 IllegalArgumentException, IllegalStateException 등과 같은 명확한 유형을 처리한다.

## 예외 상황

- [x] 사용자가 입력한 구입 금액의 단위가 1,000 단위가 아닌 경우 (IllegalArgumentException)
    - [ERROR] 구입 금액을 다시 입력해주세요. (1,000원 단위여야 합니다.)
- [x] 사용자가 입력한 구입 금액이 음수이거나 0인 경우 (IllegalArgumentException)
    - [ERROR] 구입 금액을 다시 입력해주세요. (음수나 0이면 안됩니다. 양의 정수만 입력해야 합니다.)
- [x] 사용자가 입력한 구입 금액이 문자나 공백인 경우 (IllegalArgumentException)
    - [ERROR] 구입 금액을 다시 입력해주세요. (문자나 공백이면 안됩니다. 양의 정수만 입력해야 합니다.)
- [x] 사용자가 입력한 당첨 번호가 숫자와 구분자인 쉼표(,) 기준으로 입력되지 않은 경우 (IllegalArgumentException)
    - [ERROR] 당첨 번호를 다시 입력해주세요. (숫자와 쉼표(,)만 입력해야 합니다.)
- [x] 사용자가 입력한 당첨 번호가 중복된 경우 (IllegalArgumentException)
    - [ERROR] 당첨 번호를 다시 입력해주세요. (중복된 숫자를 입력하면 안됩니다.)
- [x] 사용자가 입력한 당첨 번호가 1부터 45사이의 숫자가 아닌 경우 (IllegalArgumentException)
    - [ERROR] 당첨 번호를 다시 입력해주세요. (1부터 45사이의 숫자여야 합니다.)
- [x] 사용자가 입력한 당첨 번호는 6개가 아닌 경우 (IllegalArgumentException)
    - [ERROR] 당첨 번호를 다시 입력해주세요. (당첨 번호는 6개여야 합니다.)
- [x] 사용자가 입력한 보너스 번호가 당첨 번호와 중복된 경우 (IllegalArgumentException)
    - [ERROR] 보너스 번호를 다시 입력해주세요. (당첨 번호와 중복된 숫자를 입력하면 안됩니다.)
- [x] 사용자가 입력한 보너스 번호가 1부터 45사이의 숫자가 아닌 경우 (IllegalArgumentException)
    - [ERROR] 보너스 번호를 다시 입력해주세요. (1부터 45사이의 숫자여야 합니다.)
- [x] 사용자가 입력한 보너스 번호가 음수이거나 문자, 공백인 경우 (IllegalArgumentException)
    - [ERROR] 보너스 번호를 다시 입력해주세요. (양의 정수만 입력해야 합니다.)

## 테스트 코드

- Lotto
    - [x] 1 ~ 45 사이의 중복되지 않는 숫자 6개 로또 정상 생성
    - [x] 로또 번호의 개수가 6개가 아닐 경우 예외 발생
    - [x] 로또 번호에 중복된 숫자가 숫자가 있을 경우 예외 발생
    - [x] 로또 번호가 1 ~ 45 범위를 벗어날 경우 예외 발생
    - [x] contains() 메소드가 특정 번호의 포함 여부 정상 반환
    - [x] countMatchingNumbers() 메소드가 당첨 번호와 일치하는 개수 정상 반환
- Lottos
    - [x] Lottos 객체 정상 생성
    - [x] 수정이 불가능한 리스트 반환
    - [x] calculateStatistics() 메소드가 당첨 통게를 정상 계산
- LottoIssuer
    - [x] issue() 메소드가 구입 금액에 맞게 로또 생성
- LottoRank
    - [x] valueOf() 메소드가 일치하는 번호 개수와 보너스 번호 일치 여부에 따라 정상 반환
        - 6개 일치 -> 1등
        - 5개 일치 + 보너스 일치 -> 2등
        - 5개 일치 -> 3등
        - 4개 일치 -> 4등
        - 3개 일치 -> 5등
        - 2개 이하 일치 -> 낙첨
- LottoResult
    - [x] calculateProfitRate() 메소드가 총 상금과 구입 금액을 바탕으로 수익률 정상 계산
    - [x] 당첨금 0일 경우 수익률 0.0 반환
- PurchaseAmount
    - [x] 정상 구입 금액 객체 생성
    - [x] 구입 금액에 맞는 로또 개수 정상 반환
    - [x] 구입 금액이 1000원 단위가 아닌 경우 예외 발생
    - [x] 구입 금액이 0 또는 음수일 경우 예외 발생
    - [x] 구입 금액이 숫자가 아닌 문자나 공백일 경우 예외 발생
- BonusNumber
    - [x] 1 ~ 45 사이의 숫자, 당첨 번호와 중복되지 않는 경우 객체 정상 생성
    - [x] 보너스 번호가 1 ~ 45 범위를 벗어날 경우 예외 발생
    - [x] 보너스 번호가 이미 당첨 번호에 포함되어 있는 경우 예외 발생
    - [x] 보너스 번호가 숫자가 아닌 문자나 공백일 경우 예외 발생
- WinningLotto
    - [x] determineRank() 메소드가 주어진 로또에 대해 정확한 등수 반환
- WinningNumbers
    - [x] 1 ~ 45 사이의 중복되지 않은 숫자 6개 당첨 번호 정상 생성
    - [x] 당첨 번호의 개수가 6개가 아닐 경우 예외 발생
    - [x] 당첨 번호에 중복된 숫자가 있을 경우 예외 발생
    - [x] 입력값이 숫자와 쉼표(,) 이외의 문자를 포함할 경우 예외 발생
    - [x] 당첨 번호가 1 ~ 45 범위를 벗어날 경우 예외 발생

## 프로젝트 구조 & 설명

```
src
├── main
│   └── java/lotto
│       ├── Application.java
│       ├── controller
|       |   └── LottoController.java
│       ├── domain
|       |   ├── generator
|       |   |   ├── LottoGenerator.java
|       |   |   ├── RandomLottoGenerator.java
|       |   |   └── FixedLottoGenerator.java
|       |   ├── Lotto.java
|       |   ├── Lottos.java
|       |   ├── LottoIssuer.java
|       |   ├── LottoRank.java
|       |   ├── LottoResult.java
|       |   ├── PurchaseAmount.java
|       |   ├── BonusNumber.java
|       |   ├── WinningLotto.java
|       |   └── WinningNumbers.java
│       ├── message
|       |   └── ErrorMessage.java
│       └── view
|           ├── InputView.java
|           └── OutputView.java
└── test
    └── java/lotto
        ├── ApplicationTest.java
        └── domain
            ├── LottoTest.java
            ├── LottosTest.java
            ├── LottoIssuerTest.java
            ├── LottoRankTest.java
            ├── LottoResultTest.java
            ├── PurchaseAmountTest.java
            ├── BonusNumberTest.java
            ├── WinningLottoTest.java
            └── WinningNumbersTest.java

```

- Lotto
    - 로또 한 장을 표현하는 객체입니다. 1~45사이의 중복되지 않는 6개의 숫자를 가지며, 생성 시점에 스스로의 유효성을 검증합니다. 당첨번호와 일치하는 번호의 개수를 세거나, 특정 번호를 포함하는지 확인하는 행위를
      책임집니다.
- Lottos
    - 구매한 모든 Lotto 객체들을 관리하는 일급 컬렉션입니다. WinningLotto를 기준으로 전체 로또의 당첨 통계를 계산하는 로직을 수행합니다.
- LottoIssuer
    - 로또 발행이라는 서비스를 제공하는 객체입니다. PurchaseAmount를 받아 LottoGenerator를 통해 로또를 생성하고, 이를 Lottos 일급 컬렉션으로 묶어 반환하는 역할을 합니다.
- LottoRank
    - 1등부터 낙첨까지 각 등수에 대한 모든 정보를 가지고 있는 enum 객체입니다. 로또 한 장을 받아 최종 등수를 판별하는 책임을 가집니다.
- LottoResult
    - 최종 당첨 통계를 기반으로 생성되는 결과 객체입니다. 총상금을 계산하고, PurchaseAmount를 바탕으로 수익률을 계산하는 책임을 가집니다.
- PurchaseAmount
    - 사용자가 지불한 구입 금액을 표현하는 값 객체입니다. 생성 시점에 1,000원 단위의 양수인지 검증하며, 이 금액으로 구매할 수 있는 로또의 개수를 계산하는 책임을 가집니다.
- BonusNumber
    - 사용자가 입력한 보너스 번호 1개를 표현하는 값 객체입니다. 생성 시점에 번호의 유효성뿐만 아니라, WinningNumbers와 중복되지 않는지까지 검증하는 책임을 가집니다.
- WinningLotto
    - WinningNumbers와 BonusNumber를 조합하여 하나의 당첨 기준을 표현하는 객체입니다. 로또 한 장을 받아 최종 등수를 판별하는 책임을 가집니다.
- WinningNumbers
    - 사용자가 입력한 당첨 번호 6개를 표현하는 값 객체입니다. 생성 시점에 입력된 문자열을 파싱하고, 번호의 개수, 범위, 중복 여부 등 모든 유효성을 검증합니다.
- LottoGenerator
    - 로또 번호 생성 전략에 대한 인터페이스입니다. 이를 통해 실제 랜덤 번호 생성 로직과 테스트용 고정 번호 생성 로직을 분리하고 교체할 수 있습니다.
- RandomLottoGenerator
    - LottoGenerator의 구현체로, camp.nextstep.edu.missionutils.Randoms를 사용하여 실제 무작위 로또 번호를 생성합니다. 애플리케이션 실제 동작에 사용됩니다.
- FixedLottoGenerator
    - LottoGenerator의 구현체로, 항상 미리 정해진 고정된 번호를 반환합니다. 테스트 코드에서 예측 가능한 시나리오를 만들기 위해 사용됩니다.

---

## 고민한 점

### View를 다시 인스턴스 클래스로 바꾼 이유

2주차 미션을 진행할 때, 저는 InputView와 OutputView를 static 메소드로만 구성된 유틸리티 클래스로 설계했습니다.

이때 유틸리티 클래스로 구성한 이유는 “View는 별도의 상태를 갖지 않고, 순수한 입출력 기능만 제공하므로 객체 생성이 불필요한 비용”이라고 판단했었습니다. 이는 상태 없는 유틸리티 클래스에 대한 합리적인 접근이었습니다.

하지만 3주차 미션을 통해 객체지향 설계에 대해 더 깊이 고민하면서, 이런 설계를 가진 한계를 깨달았습니다.

static 메소드 호출은 구체적인 클래스에 직접 의존하는 것입니다. 이는 SOLID 원칙 중 하나의 의존관계 역전 원칙(DIP)을 위배합니다. Controller가 InputView라는 구체적인 구현체에 묶여버리는 것입니다.

인스턴스를 주입받는 방식으로 변경함으로써, Controller는 더 이상 View의 구체적인 구현 방식에 대해 알 필요가 없어졌습니다.

DIP 위배 외에도, “View는 상태가 없다”는 2주차의 초기 가정 자체가 위험할 수 있었습니다. 만약 “모든 라운드 결과를 모았다가 한 번에 출력”해야 한다면, static 클래스는 이 상태를 저장할 곳이 마땅치 않습니다. 하지만
인스턴스 클래스는 ‘List<String> buffer’ 같은 멤버 변수(상태)를 가져 이러한 요구사항 변경에 유연하게 대응할 수 있습니다.

그리고 인스턴스 방식은 생명주기, 리소스 관리를 명확하게 해준다는 장점이 있습니다.

static은 애플리케이션 시작부터 종료까지 살아있는 반면에 인스턴스는 new로 생성되고 소멸되는 생명주기를 가집니다. 이 생명주기를 관리할 수 있다는 것이 중요한 차이입니다.

예를 들어, “camp.nextstep.edu.missionutils.Console”은 사용이 끝나면 Console.close()를 호출해 리소스를 정리해 주어야 합니다. static View는 언제 close()를 호출해야 할지 그
시점이 애매하고, 책임을 질 객체가 불분명합니다.

하지만 Instance View는 Controller가 멤버 변수로 소유하고 있으므로, Controller의 run() 메소드가 끝나는 시점에 this.inputView.close() 처럼 소유자가 명확하게 리소스를 관리해줄 수
있습니다.

그래서 2주차의 선택이 틀렸느냐? 그 말은 아닙니다. 더 유지보수하기 좋고, 확장 가능한 코드란 무엇인지 고민하게 되었습니다.

단순히 static 키워드를 제거한 것이 아닙니다. 의존성 주입을 통해 유연한 설계를 구현하고, 상태와 생명주기 관리의 책임을 명확히 하여, 객체지향의 핵심 원칙을 코드로 실천하는 과정이었습니다.

### 에러 메시지 관리 방법

애플리케이션에서 발생하는 다양한 예외 상황에 대한 에러 메시지를 일관되게 관리하는 것은 매우 중요합니다.

처음에는 이 메시지들을 public static final String 상수로 하여 유틸리티 클래스에 모아두는 방식을 사용했습니다.

이 방법이 모든 메시지를 한곳에서 관리할 수 있어서 편리해 보였습니다.

```java
// 초기 에러 메시지 유틸리티 클래스
public class ErrorMessage {
    public static final String ERROR_MESSAGE_INVALID_UNIT = "[ERROR] ~~~";
}
```

하지만 이 방식은 여러 가지 한계가 있었습니다.

문제는 String이라는 원시 타입이 가진 본질적인 한계였습니다. 컴파일러 입장에서 ErrorMessage.INVALID_UNIT과 단순한 문자열 “Hello”는 구분되지 않는 같은 String 타입입니다. 이는 잠재적인 버그로
이어질 수 있으며, 코드의 의도를 명확히 전달하는데 방해가 되었습니다.

더 큰 문제는 책임의 분산이었습니다. 모든 에러 메시지에 “[ERROR]”이라는 접두사를 붙여야 하는 요구사항 이었는데, 이 책임을 각 상수 문자열이 개별적으로 나눠서 지고 있었습니다. 만약 접두사를 [Error]로 변경해야 한다면,
모든 상수를 하나씩 찾아 수정해야만 했습니다. 이는 DRY(Don't Repeat Yourself, 중복배제) 원칙을 위배하며 실수가 발생하기 쉬운 구조였습니다.

이런 문제들을 해결하기 위해 저는 enum을 도입했습니다. enum은 단순히 상수를 나열하는 도구가 아니라, 상태와 행위를 함께 가지는 온전한 객체입니다.

```java
//Enum 클래스
public enum ErrorMessage {
    INVALID_UNIT("구입 금액을 다시 입력해주세요. (1,000원 단위여야 합니다.)"),
    // ...

    private static final String PREFIX = "[ERROR] ";
    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return PREFIX + message;
    }
    }
```

enum으로 전환함으로써 다양한 이점들을 얻을 수 있었습니다.

첫 번째로, 에러 메시지는 ErrorMessage라는 고유한 타입을 가집니다. 코드의 안정성을 높이고, 메소드 시그니처만으로도 어떤 종류의 메시지가 필요한지 명확하게 알 수 있게 해줍니다.

두 번째로, [ERROR] 접두사를 붙이는 책임은 이제 전적으로 enum의 getMessage() 메소드가 담당합니다. 각 enum 상수는 순수한 메시지 내용에만 집중할 수 있게 되었고, 접두사 포맷 변경이 필요한 경우 단 한 곳만
수정하면 됩니다.

세 번째로, 가독성과 유지보수성이 향상되었습니다.

예를 들어,

```java
throw new IlleagalArgumentException(ErrorMessage.INVALID_UNIT.getMessage());
```

와 같은 코드는 “INVALID_UNIT이라는 특정 타입의 에러 메시지를 가져와 예외를 발생시킨다.”라는 의도를 명확하게 드러냅니다.

이와 같이 에러 메시지 관리에 enum을 도입한 것은 단순한 코드 변경을 넘어서 더 견고하고 유지보수하기 좋은 설계였음을 깨달았습니다.

### View에서 Domain을 알아도 되는가?

이번 미션을 진행하면서 가장 고민했던 부분 중 하나는 “View가 Domain 객체를 알아도 되는가” 였습니다.

객체지향의 계층형 아키텍처 원칙에 따르면, Veiw는 비즈니스 로직을 담고 있는 Domain 계층에 직접 의존해서는 안됩니다. 각 계층의 관심사를 명확히 분리하여 유연하고 확장 가능한 구조를 만들기 위함입니다.

저는 이 원칙을 지키기 위해 처음에 Controller가 중간에서 DTO에 데이터를 담아 보내는 설계를 고려했습니다.

1. Controller가 LottoIssuer로 부터 Lottos라는 도메인 객체르 받는다.
2. Controller는 Lottos 객체에서 View에 필요한 데이터만 추출하여 LottosDto라는 순수한 데이터 전송 객체로 변환한다.
3. View는 이 LottosDto만 전달받아, 도메인 로직에 대한 정보 없이 오직 화면에 데이터를 그리는 책임만 수행한다.

이 방식은 View와 Domain의 결합을 없게하여, 도메인의 변경이 View에 영향을 주지 않고, 그 반대도 마찬가지인 구조입니다.

하지만 이 구조는 현재 프로젝트 규모에서 몇 가지 문제점이 있었습니다.

화면에 데이터를 표시하기 위해 매번 DTO 클래스를 추가로 정의하고, Controller에서 도메인 객체를 DTO로 변환하는 코드를 작성해야 했습니다. 이는 코드의 양을 더 늘리고, 데이터 흐름을 추적하는 데 불필요한 복잡성을 더하는
것처럼 느껴졌습니다.

그래서 고민하고 고민한 끝에 “정해진 규칙 하에 제어된 의존성은 허용한다”는 타협안을 선택했습니다.

여기서 규칙은 아래와 같습니다.

“View는 Domain 객체를 오직 화면 표시에 필요한 데이터를 조회(Read-Only)하는 용도로만 사용해야 한다. 상태를 변경하거나 복잡한 비즈니스 로직을 담은 메소드를 호출해서는 안된다”

현재 OutputView의 printPurchasedLottos 메소드는 Lottos 객체를 전달받지만, getCount()나 getLottos()와 같이 상태를 변경하지 않는 단순 조회 메소드만 호출합니다.

```java
public void printPurchasedLottos(Lottos lottos) {
    System.out.printf(OUTPUT_MESSAGE_PURCHASE_COUNT, lottos.getCount());
    lottos.getLottos().forEach(lotto -> System.out.println(lotto.getNumbers()));
}
```

이런 접근은 DTO를 만드는 비용 없이 코드를 간결하게 유지하면서도, View가 Domain의 핵심 로직을 침범하지 못하도록 역할을 제한하는 방법이었습니다.

결론적으로, 저는 무조건적인 분리보다는 프로젝트의 규모와 복잡도에 맞는 트레이드오프를 고려하는 것이 좋은 설계의 핵심이었습니다.

### LottoRank enum 클래스. BiPredicate, 전략 패턴 적용

LottoRank enum을 어떻게 설계할지, 이 부분에서 많은 고민이 있었습니다.

처음에는 ‘등수’를 판별하는 거니까, valueOf라는 메소드 하나에 “if (matchCount == 6) …” 이런식으로 절차적인 if 로직을 전부 넣는 방색을 생각했습니다. 이 방법이 가장 직관적이고 단순해 보였기 때문입니다.

하지만 이렇게 구현하면 몇 가지 문제가 보였습니다.

valueOf 메소드 하나가 너무 비대해지고, ‘등수’라는 데이터는 enum이 가지고 ‘판별 로직’은 valueOf가 갖게 돼서 책임이 분산되는 것 같았습니다.

무엇보다 가장 큰 문제는, 만약 2.5등 같은 새로운 등수 규칙이 생긴다면 valueOf 메소드의 if문 자체를 직접 수정해야 한다는 점이었습니다. 이건 개방-폐쇄 원칙(OCP)에 어긋난다고 생각했습니다.

그래서 각 enum 상수가 자신의 판별 규칙을 스스로 책임지게 하자는 방향을 잡았습니다.

BIPredicate<Integer, Boolean>라는 함수형 인터페이스가 일치 개수와 보너스 여부라는 두 개의 입력을 받아 true/false를 반환하기에 딱 맞았습니다. 이것을 전략처럼 각 enum 상수가 직접 갖도록
설계했습니다.

```java
public enum LottoRank {

    FIRST(2_000_000_000, "6개 일치", (matchCount, matchBonus) -> matchCount == 6),
    SECOND(30_000_000, "5개 일치, 보너스 볼 일치", (matchCount, matchBonus) -> matchCount == 5 && matchBonus),
    THIRD(1_500_000, "5개 일치", (matchCount, matchBonus) -> matchCount == 5 && !matchBonus),
    // ...
    MISS(0, "낙첨", (matchCount, matchBonus) -> true);

    // ...
    private final BiPredicate<Integer, Boolean> isMatch;

    LottoRank(int prizeMoney, String description, BiPredicate<Integer, Boolean> isMatch) {
        // ...
        this.isMatch = isMatch;
    }

    public static LottoRank valueOf(int matchCount, boolean matchBonus) {
        return Arrays.stream(values())
                .filter(rank -> rank.isMatch.test(matchCount, matchBonus))
                .findFirst()
                .orElse(MISS);
    }
}
```

이와 같이 구현하면서 가장 큰 장점은 OCP를 지킬 수 있게 된 점입니다. 나중에 새로운 등수 규칙이 생겨도 valueOf 메소드는 수정할 필요가 없습니다.

그리고 First라는 상수가 1등 상금 정보뿐만 아니라, 1등이 되는 방법까지 스스로 알게되면서 등수라는 객체의 응집도가 높아졌습니다.

단순히 if문을 없애는 것이 목적이 아니라, 객체에게 올바른 책임을 맡기고 변화에 유연하게 대응하기 위해 이 설계를 선택하게 되었습니다.