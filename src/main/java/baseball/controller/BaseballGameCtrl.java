package baseball.controller;

import baseball.model.BaseballGameModel;
import baseball.view.BaseballGameView;
import nextstep.utils.Console;

public class BaseballGameCtrl {

    private final BaseballGameModel baseballGameModel = new BaseballGameModel();
    private final BaseballGameView baseballGameView = new BaseballGameView();

    public BaseballGameCtrl() {
        baseballGameView.printStartMessage();
    }

    public void playBaseballGame() {
        try {
            baseballGameModel.setRandomValueList();

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
        String pattern = "^[1-9]{3}$";

        if (!inputValue.matches(pattern)) {
            baseballGameView.printValidationMessage();
            return false;
        }

        return true;
    }
}
