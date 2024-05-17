package sahil.programming.Strategies;

import sahil.programming.Models.Board;
import sahil.programming.Models.Cell;
import sahil.programming.Models.Player;

public interface BotPlayingStrategy {
    public Cell makeMove(Board board, Player player);
}
