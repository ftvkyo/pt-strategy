package View;

import View.Misc.Renderable;


public class Game extends Renderable {

    private Renderable map = new GameMap()
            //FIXME
            .setRectangle(0f, 1920*0.66f, 0f, 1080f);

    private Renderable menu = new GameMenu()
            //FIXME
            .setRectangle(1920*0.66f, 1920f, 0f, 1080f);


    @Override
    public void render() {
        map.render();
        menu.render();
    }
}
