package org.academiadecodigo.ramsters43;

import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

public class PlayerController implements KeyboardHandler {

    private Keyboard keyboard;

    private int[] keyPressEventKeys = {
            KeyboardEvent.KEY_W, KeyboardEvent.KEY_A, KeyboardEvent.KEY_S, KeyboardEvent.KEY_D,
            KeyboardEvent.KEY_UP, KeyboardEvent.KEY_DOWN, KeyboardEvent.KEY_LEFT, KeyboardEvent.KEY_RIGHT,
            KeyboardEvent.KEY_E, KeyboardEvent.KEY_Q
    };

    private Game game;

    public PlayerController(Game game) {

        this.game = game;

        keyboard = new Keyboard(this);

        init();
    }

    private void init() {

        for (int keyPressEventKey : keyPressEventKeys) {
            addKeyPressEvent(keyPressEventKey);
        }

    }

    public void addKeyPressEvent(int keyboardEventKeyNumber) {
        KeyboardEvent keyPress = new KeyboardEvent();

        keyPress.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyPress.setKey(keyboardEventKeyNumber);

        keyboard.addEventListener(keyPress);
    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {

        switch (keyboardEvent.getKey()) {

            case KeyboardEvent.KEY_W:
            case KeyboardEvent.KEY_UP:
                game.setPlayerNextMoveDirection(Direction.UP);
                break;

            case KeyboardEvent.KEY_A:
            case KeyboardEvent.KEY_LEFT:
                game.setPlayerNextMoveDirection(Direction.LEFT);
                break;

            case KeyboardEvent.KEY_S:
            case KeyboardEvent.KEY_DOWN:
                game.setPlayerNextMoveDirection(Direction.DOWN);
                break;


            case KeyboardEvent.KEY_D:
            case KeyboardEvent.KEY_RIGHT:
                game.setPlayerNextMoveDirection(Direction.RIGHT);
                break;

            case KeyboardEvent.KEY_E:
                game.setPlayerWillInteract();
                break;

            case KeyboardEvent.KEY_Q:
                System.exit(0);
                break;
        }
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }
}
