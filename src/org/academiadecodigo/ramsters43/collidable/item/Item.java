package org.academiadecodigo.ramsters43.collidable.item;

import org.academiadecodigo.ramsters43.CollisionDetector;
import org.academiadecodigo.ramsters43.Position;
import org.academiadecodigo.ramsters43.collidable.Collidable;
import org.academiadecodigo.ramsters43.collidable.CollidableType;

public abstract class Item extends Collidable {

    public Item(Position position, CollidableType collidableType, CollisionDetector collisionDetector) {
        super(position, collidableType, collisionDetector);
    }
}
