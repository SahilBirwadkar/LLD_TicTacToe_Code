package sahil.programming.Strategies;

import sahil.programming.Models.Board;
import sahil.programming.Models.Cell;
import sahil.programming.Models.CellState;
import sahil.programming.Models.Player;

// Since its an easy playing strategy, bot will fill up the cell whenever it'll find any empty cell
public class EasyPlayingStrategy implements BotPlayingStrategy{

    @Override
    public Cell makeMove(Board board,Player player) {
        for (int i=0; i< board.getDimension(); i++){
            for (int j=0; j<board.getDimension(); j++){
                Cell cell=board.getBoard().get(i).get(j);
                if (cell.getCellState() == CellState.Empty){
                    cell.setCellState(CellState.Filled);
                    cell.setPlayer(player);
                    return cell;
                }
            }
        }
        return null;
    }
}
