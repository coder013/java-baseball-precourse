package baseball.view;

import baseball.enums.NumberRangeEnum;

public class BaseballGameView {

    public void printStartMessage() {
        System.out.printf("%d ~ %d의 서로 다른 수로 이루어진 3자리 숫자를 맞추는 게임입니다.\n", NumberRangeEnum.START_NUMBER.getNumber(), NumberRangeEnum.END_NUMBER.getNumber());
    }

    public void printInputMessage() {
        System.out.print("숫자를 입력하세요. : ");
    }

    public void printValidationMessage() {
        System.out.printf("유효하지 않은 숫자입니다. %d ~ %d의 수로 이루어진 3자리 숫자를 입력하세요.\n", NumberRangeEnum.START_NUMBER.getNumber(), NumberRangeEnum.END_NUMBER.getNumber());
    }
}