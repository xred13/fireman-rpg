package org.academiadecodigo.ramsters43.collidable;

import org.academiadecodigo.ramsters43.CollisionDetector;
import org.academiadecodigo.ramsters43.Image;
import org.academiadecodigo.ramsters43.Position;
import org.academiadecodigo.ramsters43.windows.GameWindow;

public class Water extends Collidable {

    public Water(Position position, CollisionDetector collisionDetector) {
        super(position, CollidableType.WATER, collisionDetector);
        picturePath = Image.COLLIDABLE_WATER.getImagePath();
        graphics = new GameWindow.Graphics(position, picturePath);
        colidingMessagePicturePath = Image.COLLIDING_WITH_WATER.getImagePath();
    }
}
