package baseball.controller;

import baseball.enums.NumberRangeEnum;
import baseball.model.CheckValueModel;
import baseball.model.RandomValueModel;
import baseball.view.BaseballGameView;
import baseball.vo.ResultVo;
import nextstep.utils.Console;

import java.util.ArrayList;
import java.util.List;

public class BaseballGameCtrl {

    private final RandomValueModel randomValueModel = new RandomValueModel();
    private final CheckValueModel checkValueModel = new CheckValueModel();
    private final BaseballGameView baseballGameView = new BaseballGameView();

    public BaseballGameCtrl() {
        baseballGameView.printStartMessage();
    }

    public void play() {
        try {
            start();
            end();
        } catch (Exception e) {
            baseballGameView.printExceptionMessage(e);
        }
    }

    private void start() {
        List<Integer> randomValueList = randomValueModel.getRandomValueList();
        boolean result = false;

        while (!result) {
            List<Integer> inputValueList = getInputValueList(getInputValue());
            ResultVo resultVo = checkValueModel.getResult(randomValueList, inputValueList);

            baseballGameView.printResultMessage(resultVo);

            result = resultVo.getStrike() == 3;
        }
    }
    // 게임 시작

    private void end() {
        baseballGameView.printEndMessage();
    }
    // 게임 종료

    private List<Integer> getInputValueList(String inputValue) {
        List<Integer> inputValueList = new ArrayList<>();

        for (String value : inputValue.split("")) {
            inputValueList.add(Integer.parseInt(value));
        }

        return inputValueList;
    }
    // 사용자가 입력한 숫자를 List<Integer>로 변환하여 가져온다.

    private String getInputValue() {
        String inputValue = "";
        boolean result = false;

        while (!result) {
            baseballGameView.printInputMessage();

            inputValue = getUserInput();
            result = checkValidation(inputValue);
        }

        return inputValue;
    }
    // 사용자가 입력한 숫자를 가져온다.

    private String getUserInput() {
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
