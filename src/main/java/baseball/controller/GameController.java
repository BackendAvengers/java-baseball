package baseball.controller;

import baseball.domain.dto.HintsMapper;
import baseball.domain.entity.Ball;
import baseball.domain.entity.Hints;
import baseball.domain.entity.Nothing;
import baseball.domain.entity.Numbers;
import baseball.domain.entity.Regame;
import baseball.domain.entity.Strike;
import baseball.service.BallService;
import baseball.service.NothingService;
import baseball.service.StrikeService;
import baseball.view.InputView;
import baseball.view.OutputView;

public class GameController {
    private final InputView inputView;
    private final OutputView outputView;
    private final BallService ballService;
    private final NothingService nothingService;
    private final StrikeService strikeService;


    public GameController(InputView inputView, OutputView outputView, BallService ballService,
                          NothingService nothingService, StrikeService strikeService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.ballService = ballService;
        this.nothingService = nothingService;
        this.strikeService = strikeService;
    }

    public void play() {
        outputStartGameMessage();

        Numbers computerNumbers = createComputerNumbers();
        Numbers userNumbers = inputNumbers();

        Hints hints = createHints(userNumbers, computerNumbers);

        outputHints(hints);

        askRegame();
    }

    private void outputStartGameMessage() {
        outputView.start();
    }

    private Numbers inputNumbers() {
        return inputView.inputNumbers();
    }

    private Regame inputRegame() {
        return inputView.inputRegame();
    }

    private Numbers createComputerNumbers() {
        return Numbers.createRandom();
    }

    private Hints createHints(Numbers userNumbers, Numbers computerNumbers) {
        Ball ball = ballService.createBall(userNumbers, computerNumbers);
        Strike strike = strikeService.createStrike(userNumbers, computerNumbers);
        Nothing nothing = nothingService.createNothing(ball, strike);

        return new Hints(ball, strike, nothing);
    }

    private void outputHints(Hints hints) {
        outputView.outputHints(HintsMapper.of(hints));
    }

    private void askRegame() {
        Regame regame = inputRegame();

        if (regame.askRegame()) {
            play();
        }
    }
}
