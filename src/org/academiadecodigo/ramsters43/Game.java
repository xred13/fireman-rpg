package org.academiadecodigo.ramsters43;

import org.academiadecodigo.ramsters43.collidable.item.Kitten;
import org.academiadecodigo.ramsters43.exceptions.*;
import org.academiadecodigo.ramsters43.collidable.*;
import org.academiadecodigo.ramsters43.collidable.item.Bucket;
import org.academiadecodigo.ramsters43.collidable.item.Item;
import org.academiadecodigo.ramsters43.sound.Sound;
import org.academiadecodigo.ramsters43.windows.*;
import org.academiadecodigo.ramsters43.player.Player;

import java.util.ArrayList;
import java.util.List;

public class Game {

    private CollisionDetector collisionDetector = new CollisionDetector();

    private List<Collidable> collidables;

    private Sound sound;
    private Canvas canvas;
    private MessageWindow messageWindow;
    private GameWindow gameWindow;
    private InventoryWindow inventoryWindow;

    private Player player;
    private Position playerStartingPosition = new Position(1, 1);

    private Direction playerNextMoveDirection = null;
    private boolean playerWillInteract = false;

    private int delay;

    Game(int delay) {
        this.delay = delay;
    }

    void setPlayerNextMoveDirection(Direction direction) {
        playerNextMoveDirection = direction;
    }

    private void checkPlayerNextMoveDirection() {

        if (playerNextMoveDirection == null) {
            return;
        }

        try {

            player.move(playerNextMoveDirection);

            gameWindow.updateGraphicsPosition(player.getGraphics(), player.getPosition());

        } catch (CantMoveException exception) {

            try {

                messageWindow.drawPicture(getCollidableAtPosition(Position.add(player.getPosition(), playerNextMoveDirection.getUnitPosition())).getColidingMessagePicturePath());

            } catch (NoCollidableFoundException noCollidableFoundException) {

                System.out.println(noCollidableFoundException.getMessage());

            }
        }

        playerNextMoveDirection = null;
    }

    void setPlayerWillInteract() {
        playerWillInteract = true;
    }

    private void handleWater() {

        try {

            List<Bucket> buckets = player.getBuckets();

            try {

                Bucket emptyBucket = player.getEmptyBucket(buckets);

                player.fillBucket(emptyBucket);

                messageWindow.drawPicture(Image.INTERACTION_WITH_WATER_WITH_BUCKET.getImagePath());
                inventoryWindow.drawItem(Image.ITEM_BUCKET_WITH_WATER.getImagePath(), player.getBucketInventoryIndex(true));

            } catch (NoEmptyBucketFoundException exception) {

                messageWindow.drawPicture(Image.INFO_NO_EMPTY_BUCKETS.getImagePath());

            }

        } catch (NoBucketFoundException exception) {

            messageWindow.drawPicture(Image.INTERACTION_WATER_WITH_NO_BUCKET.getImagePath());

        }
    }

    private void handleFire(Collidable fire) {

        try {

            List<Bucket> buckets = player.getBuckets();

            try {

                Bucket waterBucket = player.getBucketWithWater(buckets);

                player.useBucketWater(waterBucket);

                gameWindow.hideGraphics(fire.getGraphics());
                collisionDetector.remove(fire);
                collidables.remove(fire);

                messageWindow.drawPicture(Image.INTERACTION_WITH_FIRE_WITH_WATER.getImagePath());

                inventoryWindow.drawItem(Image.ITEM_BUCKET.getImagePath(), player.getBucketInventoryIndex(false));

            } catch (NoBucketWithWaterFoundException exception) {

                messageWindow.drawPicture(Image.INTERACTION_WITH_FIRE_WITH_BUCKET.getImagePath());

            }
        } catch (NoBucketFoundException exception) {

            messageWindow.drawPicture(Image.INTERACTION_WITH_FIRE_WITH_NOTHING.getImagePath());

        }
    }

    private void handleBucket(Collidable bucket) {

        int bucketIndex = 0;

        try {

            bucketIndex = player.pickUpItem((Item) bucket);

        } catch (InventoryFullException exception) {

            messageWindow.drawPicture(Image.INFO_INVENTORY_FULL.getImagePath());
            return;

        }

        gameWindow.hideGraphics(bucket.getGraphics());
        collisionDetector.remove(bucket);

        inventoryWindow.drawItem(Image.ITEM_BUCKET.getImagePath(), bucketIndex);
        messageWindow.drawPicture(Image.INTERACTION_WITH_BUCKET.getImagePath());

    }

    private void handleKitten(Collidable kitten) {

        int kittenIndex = 0;

        try {

            kittenIndex = player.pickUpItem((Item) kitten);

        } catch (InventoryFullException exception) {

            messageWindow.drawPicture(Image.INFO_INVENTORY_FULL.getImagePath());
            return;
        }

        inventoryWindow.drawItem(Image.ITEM_KITTEN.getImagePath(), kittenIndex);

        gameWindow.hideGraphics(kitten.getGraphics());

        collisionDetector.remove(kitten);

        messageWindow.drawPicture(Image.INFO_GAME_OVER.getImagePath());
    }

    private void checkPlayerInteractions() {

        if (playerWillInteract) {

            Position targetPosition = Position.add(
                    player.getPosition(),
                    player.getForwardDirection().getUnitPosition()
            );

            try {

                Collidable collidable = getCollidableAtPosition(targetPosition);

                switch (collidable.getCollidableType()) {

                    case WATER:
                        handleWater();
                        break;

                    case FIRE:
                        handleFire(collidable);
                        break;

                    case BUCKET:
                        handleBucket(collidable);
                        break;

                    case KITTEN:
                        handleKitten(collidable);
                        break;

                }

            } catch (NoCollidableFoundException exception) {

                messageWindow.drawPicture(Image.INTERACTION_WITH_NOTHING.getImagePath());

            }

        }

        playerWillInteract = false;
    }

    private Collidable getCollidableAtPosition(Position position) throws NoCollidableFoundException {

        for (Collidable collidable : collidables) {
            if (collidable.getPosition().equals(position)) {
                return collidable;
            }
        }

        throw new NoCollidableFoundException();
    }

    private void createCollidables() {
        collidables = new ArrayList<>() {
            {

                add(new Bucket(new Position(14, 20), collisionDetector));

                add(new Fire(new Position(6, 10), collisionDetector));
                add(new Fire(new Position(6, 11), collisionDetector));
                add(new Fire(new Position(6, 12), collisionDetector));
                add(new Fire(new Position(6, 13), collisionDetector));
                add(new Fire(new Position(6, 14), collisionDetector));
                add(new Fire(new Position(7, 10), collisionDetector));
                add(new Fire(new Position(7, 14), collisionDetector));
                add(new Fire(new Position(8, 10), collisionDetector));
                add(new Fire(new Position(8, 14), collisionDetector));
                add(new Fire(new Position(9, 10), collisionDetector));
                add(new Fire(new Position(9, 14), collisionDetector));
                add(new Fire(new Position(10, 10), collisionDetector));
                add(new Fire(new Position(10, 11), collisionDetector));
                add(new Fire(new Position(10, 12), collisionDetector));
                add(new Fire(new Position(10, 13), collisionDetector));
                add(new Fire(new Position(10, 14), collisionDetector));

                add(new Kitten(new Position(8, 12), collisionDetector));

                add(new Water(new Position(0, 19), collisionDetector));
                add(new Water(new Position(0, 20), collisionDetector));
                add(new Water(new Position(0, 21), collisionDetector));
                add(new Water(new Position(0, 22), collisionDetector));
                add(new Water(new Position(0, 23), collisionDetector));
                add(new Water(new Position(1, 20), collisionDetector));
                add(new Water(new Position(1, 21), collisionDetector));
                add(new Water(new Position(1, 22), collisionDetector));
                add(new Water(new Position(1, 23), collisionDetector));
                add(new Water(new Position(2, 21), collisionDetector));
                add(new Water(new Position(2, 22), collisionDetector));
                add(new Water(new Position(2, 23), collisionDetector));
                add(new Water(new Position(3, 22), collisionDetector));
                add(new Water(new Position(3, 23), collisionDetector));
                add(new Water(new Position(4, 23), collisionDetector));
            }
        };
    }

    void init() {

        this.sound = new Sound("/resources/sound/sound.wav");

        canvas = new Canvas();

        gameWindow = canvas.getGameWindow();

        messageWindow = canvas.getMessageWindow();
        inventoryWindow = canvas.getInventoryWindow();

    }

    void play() throws InterruptedException {

        sound.play(true);
        sound.loopIndef();

        player = new Player(playerStartingPosition, collisionDetector);
        new PlayerController(this);

        createCollidables();

        messageWindow.drawPicture(Image.INFO_GAME_START.getImagePath());

        while (true) {

            checkPlayerInteractions();

            checkPlayerNextMoveDirection();

            Thread.sleep(delay);
        }
    }
}
