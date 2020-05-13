package org.academiadecodigo.ramsters43.windows;

import org.academiadecodigo.ramsters43.Position;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class MessageWindow extends Window {

    private Position picturePosition = new Position(17, 0);

    private Picture picture;

    public MessageWindow() {

        super(WindowType.MESSAGE);

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
    }

    public void drawPicture(String picturePath) {

        picture = new Picture(
                Canvas.colToX(picturePosition.getCol()),
                Canvas.rowToY(picturePosition.getRow()),
                picturePath
        );

        picture.draw();
    }
}
