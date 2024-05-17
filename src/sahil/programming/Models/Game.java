package sahil.programming.Models;

import sahil.programming.Exception.BotCountExceedsLimitException;
import sahil.programming.Exception.DuplicateSymbolException;
import sahil.programming.Exception.PlayerCountExceedsBoardException;
import sahil.programming.Strategies.WinningStrategy;
import sahil.programming.Validations.GameValidations;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private Board board;
    private List<Player> playerList;
    private List<Move> moveList;
    private GameState gameState;
    private Player winner;
    private int nextPlayerIndex;
    private List<WinningStrategy> winningStrategyList;

    public Game(Integer dimension, List<Player> playerList,
                List<WinningStrategy> winningStrategyList) {
        this.playerList = playerList;
        this.winningStrategyList = winningStrategyList;
        this.board=new Board(dimension);
        this.gameState=GameState.In_Progress;
        nextPlayerIndex=0;
        this.moveList=new ArrayList<>();
    }

    public void printBoard() {
        board.display();
    }

    public static Builder getBuilder(){
        return new Builder();
    }

    public GameState getGameState() {
        return gameState;
    }

    public Player getWinner() {
        return winner;
    }

    public void undo(){
        if (this.moveList.size()<=0){
            System.out.println("No valid moves to undo");
            return;
        }

        Move lastMove = this.moveList.get(this.moveList.size()-1);
        this.moveList.remove(lastMove);

        Cell cell = lastMove.getCell();
        cell.setCellState(CellState.Empty);
        cell.setPlayer(null);

        for (WinningStrategy ws:winningStrategyList){
            ws.handleUndo(board,lastMove);
        }

        if(nextPlayerIndex > 0){
            nextPlayerIndex--;
        }else{
            nextPlayerIndex = playerList.size()-1;
        }

    }
    public void makeMove(){
        Player player= playerList.get(nextPlayerIndex);
        Cell cell=player.makeMove(this.board);

        Move move=new Move(player,cell);
        moveList.add(move);

        if (checkWinner(board,move)){
            gameState=GameState.Concluded;
            this.winner = player;
            return;
        }

        if (this.moveList.size()==this.board.getDimension()*this.board.getDimension()){
            gameState=GameState.DRAW;
            return;
        }

        nextPlayerIndex++;
        nextPlayerIndex%=playerList.size();
    }

    public boolean checkWinner(Board board, Move move){
        for (WinningStrategy ws:winningStrategyList){
            if (ws.checkWin(board,move)){
                return true;
            }
        }
        return false;
    }

    public static class Builder{
        Integer dimensions;
        List<Player> playerList;
        List<WinningStrategy> winningStrategyList;

        public Builder setDimensions(Integer dimensions) {
            this.dimensions = dimensions;
            return this;
        }

        public Builder setPlayers(List<Player> playerList) {
            this.playerList = playerList;
            return this;
        }

        public Builder setWinningStrategyList(List<WinningStrategy> winningStrategyList) {
            this.winningStrategyList = winningStrategyList;
            return this;
        }

        public Game build() throws PlayerCountExceedsBoardException, DuplicateSymbolException, BotCountExceedsLimitException {
            //Validations:
            GameValidations.validatePlayerCountAndBoardDimensions(this.playerList,this.dimensions);
            GameValidations.validateUniqueSymbolForPlayers(this.playerList);
            GameValidations.validateBotCount(this.playerList,1);
            return new Game(this.dimensions,this.playerList,this.winningStrategyList);
        }
    }
}
