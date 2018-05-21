package View;


import View.Misc.Renderable;
import View.Notification.FieldUpdate;
import View.Notification.INotification;

import java.util.ArrayList;


class GameMapRenderable extends Renderable {

    private static final int fieldSide = 9;
    private final Renderable[][] field = new Renderable[fieldSide][fieldSide];

    GameMapRenderable() {
        colorR = 0.2f;
        colorG = 0.9f;
        colorB = 0.2f;

        for(int i = 0; i < fieldSide; i++) {
            for(int j = 0; j < fieldSide; j++) {
                Renderable tmp = new Renderable() {
                    @Override
                    public void receiveNotification(INotification n) { }
                };
                tmp.setRectangle(1f*j, 1f*(j+1), 1f*(i+1), 1f*i);
                tmp.setColor(0f, (float) (i+j)/18, (float) Math.abs(i-j)/18);
                final int row = i, col = j;
                tmp.setAction(() -> controller.fieldClickCallback(row, col));

                field[i][j] = tmp;

                addChild(tmp);
            }
        }
    }


    @Override
    public void receiveNotification(INotification n) {
        if(n instanceof FieldUpdate) {
            ArrayList<String> contents = ((FieldUpdate) n).getContents();
            int row = ((FieldUpdate) n).getRow();
            int col = ((FieldUpdate) n).getCol();
            if(contents.contains("landscape-plain")) {
                field[row][col].setColor(0.6f, 0.8f, 0.5f);
            } else if(contents.contains("landscape-mountain")) {
                field[row][col].setColor(0.5f, 0.5f, 0.5f);
            } else if(contents.contains("landscape-forest")) {
                field[row][col].setColor(0.3f, 0.5f, 0.3f);
            } else {
                field[row][col].setColor(0f, 0f, 0f);
            }
        }
    }
}
