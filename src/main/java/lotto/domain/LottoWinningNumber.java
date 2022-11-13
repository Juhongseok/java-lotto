package lotto.domain;

import static lotto.utils.StringToListConverter.convert;

public class LottoWinningNumber extends Lotto {
    private static final String EXCEPTION_MESSAGE = "1~45 사이 숫자를 입력해 주시기 바랍니다.";
    private final int bonusNumber;

    public LottoWinningNumber(String winningNumber, String bonus) {
        super(convert(winningNumber));
        int bonusNumber = validateInputIsNumber(bonus);
        this.bonusNumber = validateDuplicate(bonusNumber);
    }

    public WinningResult getResult(IssuedLotto issuedLotto) {
        return issuedLotto.compare(super.getNumbers(), bonusNumber);
    }

    private int validateInputIsNumber(String bonus) {
        int bonusNumber;
        try {
            bonusNumber = Integer.parseInt(bonus);
            validateRange(bonusNumber);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(EXCEPTION_MESSAGE);
        }
        return bonusNumber;
    }

    private void validateRange(int bonusNumber) {
        if (bonusNumber < 1 || bonusNumber > 45) {
            throw new IllegalArgumentException(EXCEPTION_MESSAGE);
        }
    }

    private int validateDuplicate(int bonusNumber) {
        if (super.hasBonusNumber(bonusNumber)) {
            throw new IllegalArgumentException(EXCEPTION_MESSAGE);
        }
        return bonusNumber;
    }

    @Override
    public String toString() {
        return super.toString() +
                ", bonusNumber : "+
                bonusNumber;
    }
}
