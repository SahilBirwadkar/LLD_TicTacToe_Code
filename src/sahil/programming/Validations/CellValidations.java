package sahil.programming.Validations;

import sahil.programming.Models.Board;
import sahil.programming.Models.CellState;

public class CellValidations {
    public static boolean validateRowCol(Board board,int row, int col){
        if (row>=board.getDimension() || row<0){
            System.out.println("Invalid row, Please try again");
            return false;
        }
        if (col>=board.getDimension() || col<0){
            System.out.println("Invalid row, Please try again");
            return false;
        }
        if(CellState.Filled.equals(board.getBoard().get(row).get(col).getCellState())){
            System.out.println("Invalid move, please try again");
            return false;
        }
        return true;
    }
}
