package sahil.programming.Strategies;

import sahil.programming.Models.Board;
import sahil.programming.Models.Move;
import sahil.programming.Models.Player;

import java.util.HashMap;
import java.util.Map;

public class RowWinningStrategies implements WinningStrategy{

    Map<Integer, Map<Character, Integer>> rowMaps = new HashMap<>();
    @Override
    public boolean checkWin(Board board, Move lastMove) {
        int row = lastMove.getCell().getRow();
        Player player = lastMove.getCell().getPlayer();

        if (!rowMaps.containsKey(row)){
            rowMaps.put(row,new HashMap<>());
        }

        Map<Character, Integer> rowCountMap = rowMaps.get(row);

        if (!rowCountMap.containsKey(player.getSymbol())){
            rowCountMap.put(player.getSymbol(),0);
        }
        rowCountMap.put(player.getSymbol(), rowCountMap.get(player.getSymbol())+1);

        if (rowCountMap.get(player.getSymbol())==board.getDimension()) {
            return true;
        }

        return false;
    }

    @Override
    public void handleUndo(Board board, Move lastMove) {
        int row = lastMove.getCell().getRow();
        Player player = lastMove.getPlayer();

        Map<Character, Integer> rowCountMap = rowMaps.get(row);

        rowCountMap.put(player.getSymbol(), rowCountMap.get(player.getSymbol())-1);
        return;
    }
}
