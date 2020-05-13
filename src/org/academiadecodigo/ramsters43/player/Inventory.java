package org.academiadecodigo.ramsters43.player;

import org.academiadecodigo.ramsters43.collidable.CollidableType;
import org.academiadecodigo.ramsters43.collidable.item.Bucket;
import org.academiadecodigo.ramsters43.collidable.item.Item;
import org.academiadecodigo.ramsters43.exceptions.InventoryFullException;

import java.util.Iterator;

public class Inventory implements Iterable<Item> {

    public static final int numberOfSlots = 4;

    private Item[] items = new Item[numberOfSlots];

    public int add(Item itemIn) throws InventoryFullException{

        for (int i = 0; i < items.length; i++) {
            if (items[i] == null) {
                items[i] = itemIn;
                return i;
            }
        }

        throw new InventoryFullException();
    }

    public int getBucketIndex(boolean isFull) {

        for (int i = 0; i < items.length; i++) {

            if(items[i] != null && items[i].getCollidableType() == CollidableType.BUCKET){

                boolean filled = ((Bucket) items[i]).isFull();

                if(isFull == filled){
                    return i;
                }

            }
        }

        return -1;
    }

    @Override
    public Iterator<Item> iterator() {

        return new Iterator<>() {

            int currentIndex = -1;

            @Override
            public boolean hasNext() {

                for (int i = currentIndex + 1; i < items.length; i++) {
                    if(items[i] != null){
                        currentIndex = i;
                        return true;
                    }
                }

                return false;
            }

            @Override
            public Item next() {
                return items[currentIndex];
            }
        };
    }
}
