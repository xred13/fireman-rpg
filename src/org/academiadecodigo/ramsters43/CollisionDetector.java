package org.academiadecodigo.ramsters43;

import org.academiadecodigo.ramsters43.collidable.Collidable;

import java.util.LinkedList;

public class CollisionDetector {

    private LinkedList<Collidable> collidables = new LinkedList<>();

    public void add(Collidable collidable){
        collidables.offer(collidable);
    }

    public void remove(Collidable collidable){
        collidables.remove(collidable);
    }

    public boolean isSafe(Position position){
        for (Collidable collidable : collidables) {
            if(collidable.getPosition().equals(position)){
                return false;
            }
        }
        return true;
    }

}
