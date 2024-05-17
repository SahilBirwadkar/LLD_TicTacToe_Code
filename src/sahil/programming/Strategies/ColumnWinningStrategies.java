package sahil.programming.Strategies;

import sahil.programming.Models.Board;
import sahil.programming.Models.Cell;
import sahil.programming.Models.Move;
import sahil.programming.Models.Player;

import java.util.HashMap;

public class ColumnWinningStrategies implements WinningStrategy{

    HashMap<Integer, HashMap<Character, Integer>> colMaps = new HashMap<>();
    @Override
    public boolean checkWin(Board board, Move lastMove) {
        Cell cell = lastMove.getCell();
        Player player = cell.getPlayer();
        int col = cell.getColumn();

        if (!colMaps.containsKey(col)){
            colMaps.put(col,new HashMap<>());
        }

        HashMap<Character, Integer> colCountMaps = colMaps.get(col);

        if (!colCountMaps.containsKey(player.getSymbol())){
            colCountMaps.put(player.getSymbol(),0);
        }
        colCountMaps.put(player.getSymbol(),colCountMaps.get(player.getSymbol())+1);

        if (colCountMaps.get(player.getSymbol())==board.getDimension()){
            return true;
        }

        return false;
    }

    @Override
    public void handleUndo(Board board, Move lastMove) {

    }
}
