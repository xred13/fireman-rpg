package org.academiadecodigo.ramsters43;

public enum Direction {
    UP(new Position(-1, 0)),
    DOWN(new Position(1, 0)),
    LEFT(new Position(0, -1)),
    RIGHT(new Position(0, 1));

    private Position unitPosition;

    Direction(Position unitPosition){
        this.unitPosition = unitPosition;
    }

    public Position getUnitPosition() {
        return unitPosition;
    }

    public Direction getOppositeDirection(){

        switch(this){
            case UP:
                return DOWN;
            case DOWN:
                return UP;
            case LEFT:
                return RIGHT;
            case RIGHT:
                return LEFT;
        }

        return null;
    }
}
