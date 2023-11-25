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
    private final StrikeService strikeService;
    private final NothingService nothingService;


    public GameController(InputView inputView, OutputView outputView, BallService ballService,
                          StrikeService strikeService, NothingService nothingService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.ballService = ballService;
        this.nothingService = nothingService;
        this.strikeService = strikeService;
    }

    public void play() {
        outputStartGameMessage();

        Numbers computerNumbers = createComputerNumbers();

        while (true) {
            Hints hints = processUserInput(computerNumbers);

            if (hints.ismeetingEndConditions()) {
                outputView.outputEndMessage();
                break;
            }
        }

        askRegame();
    }

    private Hints processUserInput(Numbers computerNumbers) {
        Numbers userNumbers = inputNumbers();
        System.out.println(userNumbers.getNumbers());
        System.out.println(computerNumbers.getNumbers());
        Hints hints = createHints(userNumbers, computerNumbers);

        outputHints(hints);

        return hints;
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
        System.out.println(ball.getCount()+" "+strike.getCount()+" "+nothing.isActivation());
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
