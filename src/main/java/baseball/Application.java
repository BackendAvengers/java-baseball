package baseball;

import baseball.config.AppConfig;
import baseball.controller.GameController;

public class Application {
    public static void main(String[] args) {
        AppConfig config = generateConfig();
        GameController gameController = generateGameController(config);
        gameController.play();
    }

    private static AppConfig generateConfig() {
        return AppConfig.getInstance();
    }

    private static GameController generateGameController(AppConfig config) {
        return config.gameController();
    }
}
