package org.academiadecodigo.ramsters43.windows;

import org.academiadecodigo.ramsters43.Image;
import org.academiadecodigo.ramsters43.Position;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class GameWindow extends Window {

    public GameWindow() {
        super(WindowType.GAME);

        init();
    }

    @Override
    public void init() {

        Picture background = new Picture(Canvas.colToX(position.getCol()), Canvas.rowToY(position.getRow()), Image.BACKGROUND_GAME_WINDOW.getImagePath());
        background.draw();
    }

    public void updateGraphicsPosition(Graphics graphics, Position position) {
        graphics.updatePosition(position);
    }

    public void hideGraphics(Graphics graphics){
        graphics.hide();
    }

    public static class Graphics {

        private Position position;
        private Picture picture;

        public Graphics(Position position, String picturePath) {

            this.position = new Position(position);

            picture = new Picture(
                    Canvas.colToX(position.getCol()),
                    Canvas.rowToY(position.getRow()),
                    picturePath
            );

            picture.draw();

        }

        private void hide() {
            picture.delete();
        }

        private void updatePosition(Position position) {

            int rowDifference = position.getRow() - this.position.getRow();
            int colDifference = position.getCol() - this.position.getCol();

            this.position.setCol(position.getCol());
            this.position.setRow(position.getRow());

            picture.translate(
                    Canvas.colToX(colDifference),
                    Canvas.rowToY(rowDifference)
            );
        }
    }
}


