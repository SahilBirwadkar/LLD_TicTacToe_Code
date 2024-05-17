package sahil.programming.Validations;

import sahil.programming.Exception.BotCountExceedsLimitException;
import sahil.programming.Exception.DuplicateSymbolException;
import sahil.programming.Exception.PlayerCountExceedsBoardException;
import sahil.programming.Models.Player;
import sahil.programming.Models.PlayerType;

import java.util.HashSet;
import java.util.List;

public class GameValidations {
    public static boolean validatePlayerCountAndBoardDimensions(List<Player> playerList, Integer dimensions)
            throws PlayerCountExceedsBoardException {
        if (playerList.size()>=dimensions){
            throw new PlayerCountExceedsBoardException();
        }
        return true;
    }

    public static boolean validateUniqueSymbolForPlayers(List<Player> playerList)
            throws DuplicateSymbolException {
        HashSet<Character> symbolSet = new HashSet<>();

        for (Player player:playerList){
            if(symbolSet.contains(player.getSymbol())){
                throw new DuplicateSymbolException();
            }
            symbolSet.add(player.getSymbol());
        }
        return true;
    }

    public static boolean validateBotCount(List<Player> playerList, Integer count)
            throws BotCountExceedsLimitException {
        int botCount=0;
        for (Player player:playerList){
            if (player.getPlayerType().equals(PlayerType.BOT)){
                botCount++;
            }

            if (botCount>count){
                throw new BotCountExceedsLimitException();
            }
        }
        return true;
    }
}
