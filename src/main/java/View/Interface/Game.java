package View.Interface;

import View.Rectangle;


public class Game implements Renderable {

    Renderable map = new Field().setRectangle(new Rectangle<>(-1f, 0.33f, -1f, 1f));

    Renderable menu = new Menu().setRectangle(new Rectangle<>(0.33f, 1f, -1f, 1f));


    @Override
    public void render(Object o) {
        map.render(o);
        menu.render(o);
    }
}
