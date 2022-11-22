package bridge;

import bridge.controller.BridgeController;
import bridge.service.BridgeGame;
import bridge.view.InputView;

import java.util.List;

public class Application {
    private static BridgeController bridgeController = new BridgeController();
    private static BridgeGame bridgeGame = new BridgeGame();
    private static InputView inputView = new InputView();
    public static void main(String[] args) {
        try {
            List<String> bridge = bridgeController.start();
            while (true) {
                if (bridgeController.repeat(bridge)) {
                    break;
                }
                String answer = inputView.readGameCommand();
                if (!bridgeGame.retry(answer)) {
                    break;
                }
            }
        } catch (Exception e) {
            e.getMessage();
        }
    }
}
