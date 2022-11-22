package bridge;

import bridge.controller.BridgeController;
import bridge.model.BridgeGame;
import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.List;

public class Application {
    private static BridgeController bridgeController = new BridgeController();
    private static BridgeGame bridgeGame = new BridgeGame();
    private static InputView inputView = new InputView();
    private static OutputView outputView = new OutputView();
    private static final String fail = "실패";
    public static void main(String[] args) {
        List<String> bridge = bridgeController.start();
        while (true) {
            if (bridgeController.repeat(bridge)) {
                break;
            }
            String answer = inputView.readGameCommand();
            if (!bridgeGame.retry(answer)) {
                outputView.printResult(fail, bridgeController.count);
                break;
            }
        }
    }
}
