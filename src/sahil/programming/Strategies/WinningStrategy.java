package sahil.programming.Strategies;

import sahil.programming.Models.Board;
import sahil.programming.Models.Move;

public interface WinningStrategy {
    boolean checkWin(Board board, Move lastMove);
    void handleUndo(Board board, Move lastMove);
}
