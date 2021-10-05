package baseball.model;

import baseball.vo.ResultVo;

import java.util.List;

public class CheckValueModel {

    public ResultVo getResult(List<Integer> randomValueList, List<Integer> inputValueList) {
        ResultVo resultVo = new ResultVo();

        for (int i = 0; i < inputValueList.size(); i++) {
            checkBall(resultVo, randomValueList, inputValueList.get(i), i);
        }

        return resultVo;
    }
    // 정답 확인 결과를 반환한다.

    private void checkBall(ResultVo resultVo, List<Integer> randomValueList, int inputValue, int index) {
        if (randomValueList.contains(inputValue)) {
            resultVo.setBall(resultVo.getBall() + 1);
            checkStrike(resultVo, randomValueList, inputValue, index);
        }
    }
    // 전달 받은 값이 볼이라면 볼 + 1, 그 후 스트라이크 검사를 진행한다.

    private void checkStrike(ResultVo resultVo, List<Integer> randomValueList, int inputValue, int index) {
        if (randomValueList.get(index) == inputValue) {
            resultVo.setStrike(resultVo.getStrike() + 1);
            resultVo.setBall(resultVo.getBall() - 1);
        }
    }
    // 전달 받은 값이 스트라이크라면 스트라이크 + 1, 볼 - 1
}
