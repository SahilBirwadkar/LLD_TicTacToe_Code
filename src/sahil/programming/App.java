package sahil.programming;

import sahil.programming.Controllers.GameController;
import sahil.programming.Exception.BotCountExceedsLimitException;
import sahil.programming.Exception.DuplicateSymbolException;
import sahil.programming.Exception.PlayerCountExceedsBoardException;
import sahil.programming.Models.*;
import sahil.programming.Strategies.ColumnWinningStrategies;
import sahil.programming.Strategies.DiagonalWinningStrategies;
import sahil.programming.Strategies.WinningStrategy;
import sahil.programming.Strategies.RowWinningStrategies;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws PlayerCountExceedsBoardException, DuplicateSymbolException, BotCountExceedsLimitException {
        GameController gameController=new GameController();
        Scanner scanner = new Scanner(System.in);
        Player playerA=new HumanPlayer("Sahil",1,'X', PlayerType.HUMAN);
        Player playerB=new BotPlayer("Gayatri", 2, 'O', PlayerType.BOT, BotDifficultyLevel.EASY);
//        Player playerB=new HumanPlayer("Gayatri", 2, 'O', PlayerType.HUMAN);


        List<Player> playerList = new ArrayList<>();
        playerList.add(playerA);
        playerList.add(playerB);
//        playerList.add(playerC);

        List<WinningStrategy> winningStrategyList = new ArrayList<>();
        WinningStrategy rowWinningStrategy = new RowWinningStrategies();
        WinningStrategy ColumnWinningStrategies = new ColumnWinningStrategies();
        WinningStrategy DiagonalWinningStrategies = new DiagonalWinningStrategies();

        winningStrategyList.add(rowWinningStrategy);
        winningStrategyList.add(ColumnWinningStrategies);
        winningStrategyList.add(DiagonalWinningStrategies);

        Game game=gameController.startGame(3, playerList,winningStrategyList);

        while (game.getGameState().equals(GameState.In_Progress)){
            game.printBoard();

            System.out.println("Do you want to undo? (y/n) :");
            String undo = scanner.next();

            if (undo.equalsIgnoreCase("y")){
                game.undo();
                continue;
            }
            game.makeMove();
        }
        game.printBoard();

        if(game.getGameState().equals(GameState.Concluded)){
            System.out.println(game.getWinner().getName() + " have won");
        }

        if (game.getGameState().equals(GameState.DRAW)){
            System.out.println("It's a draw");
        }
    }
}
