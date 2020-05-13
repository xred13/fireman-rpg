package org.academiadecodigo.ramsters43.collidable;

import org.academiadecodigo.ramsters43.CollisionDetector;
import org.academiadecodigo.ramsters43.Image;
import org.academiadecodigo.ramsters43.Position;
import org.academiadecodigo.ramsters43.windows.GameWindow;

public class Fire extends Collidable {

    public Fire(Position position, CollisionDetector collisionDetector) {
        super(position, CollidableType.FIRE, collisionDetector);
        picturePath = Image.COLLIDABLE_FIRE.getImagePath();
        graphics = new GameWindow.Graphics(position, picturePath);
        colidingMessagePicturePath = Image.COLLIDING_WITH_FIRE.getImagePath();
    }
}
