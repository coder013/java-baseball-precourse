package baseball;

import baseball.controller.BaseballGameCtrl;

public class Application {

    public static void main(String[] args) {
        BaseballGameCtrl baseballGameCtrl = new BaseballGameCtrl();
        baseballGameCtrl.playBaseballGame();
    }
}
