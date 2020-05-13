package org.academiadecodigo.ramsters43.collidable.item;

import org.academiadecodigo.ramsters43.CollisionDetector;
import org.academiadecodigo.ramsters43.Image;
import org.academiadecodigo.ramsters43.Position;
import org.academiadecodigo.ramsters43.collidable.CollidableType;
import org.academiadecodigo.ramsters43.windows.GameWindow;

public class Kitten extends Item {

    public Kitten(Position position, CollisionDetector collisionDetector) {
        super(position, CollidableType.KITTEN, collisionDetector);
        picturePath = Image.COLLIDABLE_KITTEN.getImagePath();
        graphics = new GameWindow.Graphics(position, picturePath);
        colidingMessagePicturePath = Image.COLLIDING_WITH_KITTEN.getImagePath();
    }
}
