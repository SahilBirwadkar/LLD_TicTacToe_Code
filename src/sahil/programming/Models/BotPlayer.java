package sahil.programming.Models;

import sahil.programming.Factory.BotPlayingStrategyFactory;
import sahil.programming.Strategies.BotPlayingStrategy;

public class BotPlayer extends Player{
    private BotDifficultyLevel botDifficultyLevel;
    private BotPlayingStrategy botPlayingStrategy;

    public BotPlayer(String name, int gameId, Character symbol, PlayerType playerType,
                     BotDifficultyLevel botDifficultyLevel) {
        super(name, gameId, symbol, playerType);
        this.botDifficultyLevel = botDifficultyLevel;
        this.botPlayingStrategy= BotPlayingStrategyFactory.getBotPlayingStrategy(this.botDifficultyLevel);
    }


    @Override
    public Cell makeMove(Board board) {
        //Here, we're going to identify the cell which needs to mark
        //and then update the cell with player information and cell state
        //and then return the cell
        return botPlayingStrategy.makeMove(board,this);
    }
}
