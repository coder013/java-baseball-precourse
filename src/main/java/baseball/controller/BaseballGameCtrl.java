package baseball.controller;

import baseball.enums.NumberRangeEnum;
import baseball.model.RandomValueModel;
import baseball.view.BaseballGameView;
import nextstep.utils.Console;

import java.util.List;

public class BaseballGameCtrl {

    private final RandomValueModel randomValueModel = new RandomValueModel();
    private final BaseballGameView baseballGameView = new BaseballGameView();

    public BaseballGameCtrl() {
        baseballGameView.printStartMessage();
    }

    public void playBaseballGame() {
        try {
            List<Integer> randomValueList = randomValueModel.getRandomValueList();
            int inputValue = getInputValueByInt();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private int getInputValueByInt() {
        String inputValue = "";
        boolean result = false;

        while (!result) {
            baseballGameView.printInputMessage();

            inputValue = getInputValue();
            result = checkValidation(inputValue);
        }

        return Integer.parseInt(inputValue);
    }
    // 사용자가 입력한 숫자를 가져온다.

    private String getInputValue() {
        return Console.readLine();
    }

    private boolean checkValidation(String inputValue) {
        String pattern = String.format("^[%d-%d]{3}$", NumberRangeEnum.START_NUMBER.getNumber(), NumberRangeEnum.END_NUMBER.getNumber());

        if (!inputValue.matches(pattern)) {
            baseballGameView.printValidationMessage();
            return false;
        }

        return true;
    }
}
