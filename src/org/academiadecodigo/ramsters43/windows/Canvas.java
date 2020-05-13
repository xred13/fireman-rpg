package org.academiadecodigo.ramsters43.windows;

import org.academiadecodigo.ramsters43.Position;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Canvas {

    public static final int CELL_SIZE = 50;

    public static final int ROWS = 20;
    public static final int COLS = 27;

    public static final int GAME_WINDOW_ROWS = 17;
    public static final int GAME_WINDOW_COLS = 24;
    public static final Position GAME_WINDOW_POSITION = new Position(0, 0);

    public static final int INVENTORY_WINDOW_ROWS = 17;
    public static final int INVENTORY_WINDOW_COLS = 3;
    public static final Position INVENTORY_WINDOW_POSITION = new Position(0, 24);


    public static final int MESSAGE_WINDOW_ROWS = 3;
    public static final int MESSAGE_WINDOW_COLS = 27;
    public static final Position MESSAGE_WINDOW_POSITION = new Position(17, 0);

    private MessageWindow messageWindow;
    private GameWindow gameWindow;
    private InventoryWindow inventoryWindow;

    public Canvas() {
        Rectangle canvas = new Rectangle(0, 0, colToX(COLS), rowToY(ROWS));
        canvas.setColor(Color.WHITE);
        canvas.fill();

        init();
    }

    public void init() {
        gameWindow = new GameWindow();
        messageWindow = new MessageWindow();
        inventoryWindow = new InventoryWindow();
    }

    public GameWindow getGameWindow() {
        return gameWindow;
    }

    public InventoryWindow getInventoryWindow() {
        return inventoryWindow;
    }

    public MessageWindow getMessageWindow() {
        return messageWindow;
    }

    public  static int rowToY(int row) {
        return row * CELL_SIZE;
    }

    public  static int colToX(int col) {
        return col * CELL_SIZE;
    }




}
