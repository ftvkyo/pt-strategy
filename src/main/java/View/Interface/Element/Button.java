package View.Interface.Element;

import View.Interface.Renderable;


public abstract class Button extends Renderable {

    public Button(float colorR, float colorG, float colorB) {
        this.colorR = colorR;
        this.colorG = colorG;
        this.colorB = colorB;
    }


    @Override
    protected abstract void clickEvent();
}
