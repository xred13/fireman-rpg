package org.academiadecodigo.ramsters43.player;

import org.academiadecodigo.ramsters43.CollisionDetector;
import org.academiadecodigo.ramsters43.Direction;
import org.academiadecodigo.ramsters43.Image;
import org.academiadecodigo.ramsters43.Position;
import org.academiadecodigo.ramsters43.exceptions.*;
import org.academiadecodigo.ramsters43.collidable.CollidableType;
import org.academiadecodigo.ramsters43.collidable.item.Bucket;
import org.academiadecodigo.ramsters43.collidable.item.Item;
import org.academiadecodigo.ramsters43.windows.GameWindow;

import java.util.ArrayList;
import java.util.List;

public class Player {

    private CollisionDetector collisionDetector;

    private Inventory inventory = new Inventory();

    private Position position;

    private GameWindow.Graphics graphics;

    // the direction the player is currently looking at
    private Direction forwardDirection = Direction.DOWN;

    public Player(Position position, CollisionDetector collisionDetector) {
        this.position = position;
        this.collisionDetector = collisionDetector;
        graphics = new GameWindow.Graphics(position, Image.COLLIDABLE_FIREMAN.getImagePath());
    }

    public GameWindow.Graphics getGraphics() {
        return graphics;
    }

    public int pickUpItem(Item item) throws InventoryFullException {
        return inventory.add(item);
    }

    public int getBucketInventoryIndex(boolean isFull) {
        return inventory.getBucketIndex(isFull);
    }

    public Position getPosition() {
        return position;
    }

    public Direction getForwardDirection() {
        return forwardDirection;
    }

    private void setForwardDirection(Direction direction) {
        forwardDirection = direction;
    }

    private boolean canMove() {

        Position nextPosition = Position.add(position, forwardDirection.getUnitPosition());

        return position.canMove(forwardDirection) && collisionDetector.isSafe(nextPosition);
    }

    public void move(Direction direction) throws CantMoveException {

        setForwardDirection(direction);

        if (!canMove()) {
            throw new CantMoveException();
        }

        position.move(forwardDirection);
    }

    public Bucket getEmptyBucket(List<Bucket> buckets) throws NoEmptyBucketFoundException {

        for (Bucket bucket : buckets) {
            if(!bucket.isFull()){
                return bucket;
            }
        }

        throw new NoEmptyBucketFoundException();
    }

    public Bucket getBucketWithWater(List<Bucket> buckets) throws NoBucketWithWaterFoundException{

        for (Bucket bucket : buckets) {
            if(bucket.isFull()){
                return bucket;
            }
        }

        throw new NoBucketWithWaterFoundException();
    }

    public List<Bucket> getBuckets() throws NoBucketFoundException {

        List<Bucket> buckets = new ArrayList<>();

        for (Item item : inventory) {
            if (item.getCollidableType() == CollidableType.BUCKET) {
                buckets.add((Bucket) item);
            }
        }

        if(buckets.size() > 0){
            return buckets;
        }

        throw new NoBucketFoundException();
    }

    public void fillBucket(Bucket bucket) {

        bucket.fill();

    }

    public void useBucketWater(Bucket bucket) {

        bucket.useWater();

    }

}
