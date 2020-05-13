package org.academiadecodigo.ramsters43;

public enum Image {

    BACKGROUND_INVENTORY_WINDOW("inventory.png"),
    BACKGROUND_GAME_WINDOW("game-background.png"),

    COLLIDING_WITH_BUCKET("colliding-with-bucket-message.png"),
    COLLIDING_WITH_FIRE("colliding-with-fire-message.png"),
    COLLIDING_WITH_KITTEN("colliding-with-kitten-message.png"),
    COLLIDING_WITH_WATER("colliding-with-water-message.png"),

    COLLIDABLE_FIRE("fire.png"),
    COLLIDABLE_KITTEN("kitten.png"),
    COLLIDABLE_WATER("water.png"),
    COLLIDABLE_FIREMAN("fireman.png"),
    COLLIDABLE_BUCKET("bucket.png"),

    ITEM_BUCKET("bucket_w.png"),
    ITEM_BUCKET_WITH_WATER("bucket-with-water_w.png"),
    ITEM_KITTEN("kitten_w.png"),

    INTERACTION_WITH_WATER_WITH_BUCKET("bucket-filled-message.png"),
    INTERACTION_WITH_NOTHING("what-are-you-doing.png"),
    INTERACTION_WATER_WITH_NO_BUCKET("water-with-no-bucket.png"),
    INTERACTION_WITH_FIRE_WITH_NOTHING("warm-and-cosy.png"),
    INTERACTION_WITH_FIRE_WITH_BUCKET("throw-bucket.png"),
    INTERACTION_WITH_FIRE_WITH_WATER("fire-put-down.png"),
    INTERACTION_WITH_BUCKET("a-fine-bucket.png"),

    INFO_NO_EMPTY_BUCKETS("all-buckets-full.png"),
    INFO_INVENTORY_FULL("inventory-full.png"),
    INFO_GAME_START("game-started-message.png"),
    INFO_GAME_OVER("game-over-message.png");

    private String imagePath;

    Image(String imagePath){
        this.imagePath = "resources/images/" + imagePath;
    }

    public String getImagePath() {
        return imagePath;
    }
}
