package View.Interface;

public class Game extends Renderable {

    Renderable map = new Field()
            //FIXME
            .setRectangle(0f, 1920*0.66f, 0f, 1080f);

    Renderable menu = new Menu()
            //FIXME
            .setRectangle(1920*0.66f, 1920f, 0f, 1080f);


    @Override
    public void render() {
        map.render();
        menu.render();
    }
}
