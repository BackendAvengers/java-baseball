package baseball.config;

import baseball.controller.GameController;
import baseball.service.BallService;
import baseball.service.NothingService;
import baseball.service.StrikeService;
import baseball.view.InputView;
import baseball.view.OutputView;

public class AppConfig {

    public static AppConfig getInstance() {
        return LazyHolder.INSTANCE;
    }

    public GameController gameController() {
        return LazyHolder.gameController;
    }

    private static class LazyHolder {
        private static final AppConfig INSTANCE = new AppConfig();
        private static final InputView inputView = createInputView();
        private static final OutputView outputView = createOutputView();
        private static final BallService ballService = createBallService();

        private static final StrikeService strikeService = createStrikeService();
        private static final NothingService nothingService = createNothingService();
        private static final GameController gameController = createGameController();

        private static GameController createGameController() {
            return new GameController(
                    inputView,
                    outputView,
                    ballService,
                    strikeService,
                    nothingService);
        }

        private static BallService createBallService() {
            return new BallService();
        }

        private static StrikeService createStrikeService() {
            return new StrikeService();
        }

        private static NothingService createNothingService() {
            return new NothingService();
        }

        private static InputView createInputView() {
            return new InputView();
        }

        private static OutputView createOutputView() {
            return new OutputView();
        }
    }
}
