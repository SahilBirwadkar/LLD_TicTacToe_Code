package sahil.programming.Controllers;

import sahil.programming.Exception.BotCountExceedsLimitException;
import sahil.programming.Exception.DuplicateSymbolException;
import sahil.programming.Exception.PlayerCountExceedsBoardException;
import sahil.programming.Models.Game;
import sahil.programming.Models.Player;
import sahil.programming.Strategies.WinningStrategy;

import java.util.List;

public class GameController {
    public Game startGame(Integer dimension, List<Player> playerList, List<WinningStrategy> winningStrategyList)
            throws PlayerCountExceedsBoardException, DuplicateSymbolException, BotCountExceedsLimitException {
        System.out.println("The game of TicTacToe Begins");
        return Game.getBuilder()
                .setDimensions(dimension)
                .setPlayers(playerList)
                .setWinningStrategyList(winningStrategyList).build();
    }

    public void makeMove(Game game){
        game.makeMove();

    }

    public void printBoard(Game game){
        game.printBoard();
    }

    public void undo(){

    }
}
