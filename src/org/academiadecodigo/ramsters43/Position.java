package org.academiadecodigo.ramsters43;

import org.academiadecodigo.ramsters43.windows.Canvas;

public class Position {

    private int col;
    private int row;

    public Position(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public Position(Position position){
        row = position.row;
        col = position.col;
    }

    public int getCol() {
        return col;
    }

    public int getRow() {
        return row;
    }

    public void setCol(int col){
        this.col = col;
    }

    public void setRow(int row){
        this.row = row;
    }

    private void moveUp(){
        row--;
    }

    private void moveDown(){
        row++;
    }

    private void moveLeft(){
        col--;
    }

    private void moveRight(){
        col++;
    }

    public boolean canMove(Direction direction){

        switch(direction){
            case UP:
                return row > 0;
            case DOWN:
                return row < Canvas.GAME_WINDOW_ROWS - 1;
            case LEFT:
                return col > 0;
            case RIGHT:
                return col < Canvas.GAME_WINDOW_COLS - 1;
        }

        return false;
    }

    public void move(Direction direction){

        switch(direction){
            case UP:
                moveUp();
                break;
            case DOWN:
                moveDown();
                break;
            case LEFT:
                moveLeft();
                break;
            case RIGHT:
                moveRight();
                break;
        }
    }

    public boolean equals(Position position){
        return col == position.col && row == position.row;
    }

    public static Position add(Position position1, Position position2){
        return new Position(position1.row + position2.row, position1.col + position2.col);
    }
}
