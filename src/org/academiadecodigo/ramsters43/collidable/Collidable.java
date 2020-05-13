package org.academiadecodigo.ramsters43.collidable;

import org.academiadecodigo.ramsters43.CollisionDetector;
import org.academiadecodigo.ramsters43.Position;
import org.academiadecodigo.ramsters43.windows.GameWindow;

public abstract class Collidable {

    protected GameWindow.Graphics graphics;

    protected String picturePath;

    protected Position position;

    private CollidableType collidableType;

    protected String colidingMessagePicturePath;

    public Collidable(Position position, CollidableType collidableType, CollisionDetector collisionDetector) {
        this.position = position;
        this.collidableType = collidableType;
        collisionDetector.add(this);
    }

    public CollidableType getCollidableType() {
        return collidableType;
    }

    public GameWindow.Graphics getGraphics() {
        return graphics;
    }

    public String getPicturePath(){
        return picturePath;
    }

    public Position getPosition() {
        return position;
    }

    protected void setPosition(Position position) {
        this.position = position;
    }

    public String getColidingMessagePicturePath() {
        return colidingMessagePicturePath;
    }
}
