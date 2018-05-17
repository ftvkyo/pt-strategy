package View;

import View.Misc.Rectangle;
import View.Misc.Renderable;
import View.Misc.Tickbox;

import java.util.ArrayList;


public class Settings extends Renderable {

    GameView view;

    GameRenderer renderer;

    ArrayList<Renderable> controls = new ArrayList<>();

    public Settings(GameView view, GameRenderer renderer) {
        this.view = view;
        this.renderer = renderer;
        this.rect = new Rectangle<>(0f, 1920f, 1080f, 0f);

        controls.add(new Tickbox(0.9f, 0.5f, 0.5f)
                        .setRectangle(10f, 50f, 50f, 10f));

        controls.add(new Renderable(0.2f, 0.2f, 0.2f) {
            @Override
            protected void clickEvent() {
                this.colorR += 0.2f;
                if(this.colorR > 1.f) {
                    colorR -= 1.f;
                }
            }
        }.setRectangle(60f, 100f, 50f, 10f));

        controls.add(new Renderable(0f, 1f, 0f) {
            @Override
            protected void clickEvent() {
                //TODO: start game
            }
        }.setRectangle(110f, 150f, 50f, 10f));


        controls.add(new Renderable(1f, 0f, 0f) {
            @Override
            protected void clickEvent() {
                //TODO: restart game
            }
        }.setRectangle(160f, 200f, 50f, 10f));
    }


    public void clickEvent(float xpos, float ypos) {
        for(Renderable control: controls) {
            control.clickEvent(xpos, ypos);
        }
    }


    @Override
    protected void renderState() {
        for(Renderable control: controls) {
            control.render();
        }
    }
}
