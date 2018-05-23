package View.Misc;


import Controller.Controller;
import View.InterfaceDescription.RenderableDescription;
import View.Notification.FieldUpdate;
import View.Notification.INotification;

import java.util.ArrayList;


public class GameMap extends Renderable {

    private static final int fieldSide = 27;
    private final Renderable[][] field = new Renderable[fieldSide][fieldSide];

    public GameMap(Controller controller, String id, RenderableDescription description) {
        super(controller, id, description);

        //BUG: Наследовать края от контейнера, а не отсчитывать от края экрана.

        float sizeOfCell = 9f/fieldSide;

        for(int i = 0; i < fieldSide; i++) {
            for(int j = 0; j < fieldSide; j++) {
                final int row = i, col = j;

                field[i][j] = new Renderable();
                //field[i][j].setColor(0f, (float) (i+j)/18, (float) Math.abs(i-j)/18);
                field[i][j].setShape(sizeOfCell*j, sizeOfCell*(j+1), sizeOfCell*(i+1), sizeOfCell*i);
                field[i][j].setAction(() -> controller.fieldClickCallback(row, col));

                children.add(field[i][j]);
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
