package sahil.programming.Models;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private int dimension;
    private List<List<Cell>> board;

    public Board(int dimension) {
        this.dimension = dimension;
        this.board=new ArrayList<>();

        for (int i=0; i<dimension; i++){
            board.add(new ArrayList<>());
            for (int j=0; j<dimension; j++){
                board.get(i).add(new Cell(i,j));                // Here, we're creating empty cell
            }
        }
    }

    public void display(){
        System.out.println("Current Board:");
        for (int i=0; i<dimension; i++){
            for (int j=0; j<dimension; j++){
                board.get(i).get(j).display();
            }
            System.out.println();
        }
    }

    public List<List<Cell>> getBoard() {
        return board;
    }

    public int getDimension() {
        return dimension;
    }
}
