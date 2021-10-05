package baseball.view;

import baseball.enums.NumberRangeEnum;
import baseball.vo.ResultVo;

public class BaseballGameView {

    public void printStartMessage() {
        System.out.printf("%d ~ %d의 서로 다른 수로 이루어진 3자리 숫자를 맞추는 게임입니다.\n", NumberRangeEnum.START_NUMBER.getNumber(), NumberRangeEnum.END_NUMBER.getNumber());
    }

    public void printInputMessage() {
        System.out.print("숫자를 입력하세요. : ");
    }

    public void printValidationMessage() {
        System.out.printf("[ERROR] 유효하지 않은 숫자입니다. %d ~ %d의 수로 이루어진 3자리 숫자를 입력하세요.\n", NumberRangeEnum.START_NUMBER.getNumber(), NumberRangeEnum.END_NUMBER.getNumber());
    }

    public void printResultMessage(ResultVo resultVo) {
        System.out.println(getResultMessage(resultVo));
    }

    private String getResultMessage(ResultVo resultVo) {
        if (resultVo.getStrike() > 0 && resultVo.getBall() > 0) {
            return String.format("%d스트라이크 %d볼", resultVo.getStrike(), resultVo.getBall());
        }

        if (resultVo.getStrike() > 0) {
            return String.format("%d스트라이크", resultVo.getStrike());
        }

        if (resultVo.getBall() > 0) {
            return String.format("%d볼", resultVo.getBall());
        }

        return "낫싱";
    }

    public void printEndMessage() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 끝");
    }

    public void printRestartMessage() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }

    public void printRestartValidationMessage() {
        System.out.println("[ERROR] 유효하지 않은 숫자입니다. 게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }
}