package sahil.programming.Strategies;

import sahil.programming.Models.Board;
import sahil.programming.Models.Move;
import sahil.programming.Models.Player;

import java.util.HashMap;

    public class DiagonalWinningStrategies implements WinningStrategy{
    HashMap<Integer, HashMap<Character, Integer>> diaMap = new HashMap<>();
    @Override
    public boolean checkWin(Board board, Move lastMove) {
        int row = lastMove.getCell().getRow();
        int col = lastMove.getCell().getColumn();
        Player player = lastMove.getCell().getPlayer();

        if (row==col){
            if (!diaMap.containsKey(0)){
                diaMap.put(0,new HashMap<>());
            }
            HashMap<Character, Integer> FirstDiaCountMap = diaMap.get(0);

            if (!FirstDiaCountMap.containsKey(player.getSymbol())){
                FirstDiaCountMap.put(player.getSymbol(),0);
            }
            FirstDiaCountMap.put(player.getSymbol(), FirstDiaCountMap.get(player.getSymbol())+1);
            if(FirstDiaCountMap.get(player.getSymbol()).equals(board.getDimension())){
                return true;
            }
        }
        return false;
    }

    @Override
    public void handleUndo(Board board, Move lastMove) {

    }
}
