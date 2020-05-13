package org.academiadecodigo.ramsters43.collidable.item;

import org.academiadecodigo.ramsters43.CollisionDetector;
import org.academiadecodigo.ramsters43.Image;
import org.academiadecodigo.ramsters43.Position;

import org.academiadecodigo.ramsters43.windows.GameWindow;
import org.academiadecodigo.ramsters43.collidable.CollidableType;

public class Bucket extends Item {

    private boolean full = false;

    public Bucket(Position position, CollisionDetector collisionDetector) {
        super(position, CollidableType.BUCKET, collisionDetector);
        picturePath = Image.COLLIDABLE_BUCKET.getImagePath();
        graphics = new GameWindow.Graphics(position, picturePath);
        colidingMessagePicturePath = Image.COLLIDING_WITH_BUCKET.getImagePath();
    }

    public boolean isFull() {
        return full;
    }

    public void fill() {
        full = true;
    }

    public void useWater(){
        full = false;
    }
}
