package View.Interface;

import View.Interface.Element.Button;
import View.Interface.Element.Tickbox;
import View.Rectangle;

import java.util.ArrayList;


public class Settings extends Renderable {

    ArrayList<Renderable> controls = new ArrayList<>();

    public Settings() {

        //FIXME
        rect = new Rectangle<>(0f, 1920f, 1080f, 0f);

        controls.add(new Tickbox(0.9f, 0.5f, 0.5f)
                        .setRectangle(10f, 50f, 50f, 10f));

        controls.add(new Button(0.2f, 0.2f, 0.2f) {
            @Override
            protected void clickEvent() {
                this.colorR += 0.2f;
                if(this.colorR > 1.f) {
                    colorR -= 1.f;
                }
            }
        }.setRectangle(60f, 100f, 50f, 10f));

        controls.add(new Button(0f, 1f, 0f) {
            @Override
            protected void clickEvent() {
                System.out.println("Should begin the game");
            }
        }.setRectangle(110f, 150f, 50f, 10f));
    }


    public void clickEvent(float xpos, float ypos) {
        System.out.println("Passing clickEvent to controls");
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
