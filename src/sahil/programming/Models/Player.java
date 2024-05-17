package sahil.programming.Models;

public abstract class Player {
    private String name;
    private int GameId;
    private Character symbol;
    private PlayerType playerType;

    public abstract Cell makeMove(Board board);

    public Player(String name, int gameId, Character symbol, PlayerType playerType) {
        this.name = name;
        GameId = gameId;
        this.symbol = symbol;
        this.playerType = playerType;
    }

    public Character getSymbol() {
        return symbol;
    }

    public PlayerType getPlayerType() {
        return playerType;
    }

    public String getName() {
        return name;
    }
}
