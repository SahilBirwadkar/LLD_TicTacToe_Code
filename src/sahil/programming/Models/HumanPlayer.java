package sahil.programming.Models;

import sahil.programming.Validations.CellValidations;

import java.util.Scanner;

public class HumanPlayer extends Player{



    Scanner scanner;

    @Override
    public Cell makeMove(Board board) {
        System.out.println(this.getName() + ", It's your move. Please input the row and column");
        int row=0;
        int col=0;
        do{
            row = scanner.nextInt();
            col = scanner.nextInt();
        }while (!CellValidations.validateRowCol(board,row,col));

        Cell cell=board.getBoard().get(row).get(col);
        cell.setPlayer(this);
        cell.setCellState(CellState.Filled);
        return cell;
    }

    public HumanPlayer(String name, int gameId, Character symbol,
                       PlayerType playerType) {
        super(name, gameId, symbol, playerType);
        scanner=new Scanner(System.in);
    }
}
