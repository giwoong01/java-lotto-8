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