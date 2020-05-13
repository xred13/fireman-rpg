package org.academiadecodigo.ramsters43.windows;

import org.academiadecodigo.ramsters43.Image;
import org.academiadecodigo.ramsters43.Position;
import org.academiadecodigo.ramsters43.player.Inventory;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class InventoryWindow extends Window {

    private InventorySlot[] inventorySlots = new InventorySlot[Inventory.numberOfSlots];

    private int slotsStartingRow = 4;
    private int slotsCol = 1;

    public InventoryWindow() {

        super(WindowType.INVENTORY);

        init();
    }

    @Override
    public void init() {

        Rectangle rect = new Rectangle(
                Canvas.colToX(position.getCol()),
                Canvas.rowToY(position.getRow()),
                Canvas.colToX(cols),
                Canvas.rowToY(rows)
        );

        rect.setColor(Color.LIGHT_GRAY);
        rect.fill();

        initBackground();
        initInventorySlots();

    }

    private void initBackground(){
        Picture picture = new Picture(Canvas.colToX(position.getCol()), Canvas.rowToY(position.getRow()), Image.BACKGROUND_INVENTORY_WINDOW.getImagePath());
        picture.draw();
    }

    private void initInventorySlots(){
        for (int i = 0; i < inventorySlots.length; i++) {
            inventorySlots[i] = new InventorySlot(new Position(slotsStartingRow + i, slotsCol));
        }
    }

    public void drawItem(String picturePath, int inventoryIndex) {

        inventorySlots[inventoryIndex].updateGraphics(picturePath);

    }

    private class InventorySlot{

        private Picture graphics;

        private InventorySlot (Position slotPosition){

            graphics = new Picture(Canvas.colToX(position.getCol() + slotPosition.getCol()), Canvas.rowToY(position.getRow() + slotPosition.getRow()), Image.COLLIDABLE_FIREMAN.getImagePath());
        }

        private void updateGraphics(String picturePath){
            graphics.load(picturePath);
            graphics.draw();
        }
    }
}
