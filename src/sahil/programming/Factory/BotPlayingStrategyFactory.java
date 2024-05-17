package sahil.programming.Factory;

import sahil.programming.Models.BotDifficultyLevel;
import sahil.programming.Strategies.BotPlayingStrategy;
import sahil.programming.Strategies.EasyPlayingStrategy;

public class BotPlayingStrategyFactory {
    public static BotPlayingStrategy getBotPlayingStrategy(BotDifficultyLevel difficultyLevel){
        return new EasyPlayingStrategy();
    }
}
