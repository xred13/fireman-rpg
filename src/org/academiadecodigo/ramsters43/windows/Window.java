package org.academiadecodigo.ramsters43.windows;

import org.academiadecodigo.ramsters43.Position;

public abstract class Window {

    private WindowType windowType;

    protected Position position;
    protected int rows;
    protected int cols;

    public Window(WindowType windowType) {
        this.windowType = windowType;

        setInitialState();
    }

    private void setInitialState() {

        switch (windowType) {

            case GAME:
                cols = Canvas.GAME_WINDOW_COLS;
                rows = Canvas.GAME_WINDOW_ROWS;
                position = Canvas.GAME_WINDOW_POSITION;
                break;

            case MESSAGE:
                cols = Canvas.MESSAGE_WINDOW_COLS;
                rows = Canvas.MESSAGE_WINDOW_ROWS;
                position = Canvas.MESSAGE_WINDOW_POSITION;
                break;

            case INVENTORY:
                cols = Canvas.INVENTORY_WINDOW_COLS;
                rows = Canvas.INVENTORY_WINDOW_ROWS;
                position = Canvas.INVENTORY_WINDOW_POSITION;
                break;
        }
    }

    public abstract void init();
}
