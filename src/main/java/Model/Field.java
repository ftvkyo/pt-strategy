package Model;

import Model.Item.GenericItem;
import Model.Landscape.ForestLandscape;
import Model.Landscape.GenericLandscape;
import Model.Landscape.MountainLandscape;
import Model.Landscape.PlainLandscape;
import Model.Unit.IUnit;

import java.util.ArrayList;
import java.util.Random;


/**
 * Обычное поле, просто карта игры.
 */
class Field {
    final int fieldSize = 9;

    GenericLandscape[][] field = new GenericLandscape[fieldSize][fieldSize];

    private GenericLandscape.GenericLandscapeFactory[] availableLandscapes = {
            new PlainLandscape.LandscapeFactory(),
            new ForestLandscape.LandscapeFactory(),
            new MountainLandscape.LandscapeFactory()
    };


    Field() {
        reset();
    }


    public void reset() {
        Random r = new Random();

        for(int row = 0; row < fieldSize; row++) {
            for(int col = 0; col < fieldSize; col++) {
                int choice = r.nextInt(availableLandscapes.length);
                field[row][col] = availableLandscapes[choice].createInstance();
            }
        }
    }


    public ArrayList<String> getCellContents(int row, int col) {
        ArrayList<String> result = new ArrayList<>();
        result.add(field[row][col].getID());

        IUnit u = field[row][col].getUnit();
        if(u != null) {
            result.add(u.getID());
        }

        for(GenericItem item : field[row][col].getItems()) {
            result.add(item.getID());
        }

        return result;
    }
}
