package View.Interface.Element;


import View.Interface.Renderable;
import View.Rectangle;

import static java.lang.Math.abs;
import static org.lwjgl.opengl.GL11.*;


public class Tickbox extends Renderable {

    private boolean checked = false;


    public Tickbox(float colorR, float colorG, float colorB) {
        this.colorR = colorR;
        this.colorG = colorG;
        this.colorB = colorB;
    }


    public Tickbox setChecked(boolean checked) {
        this.checked = checked;
        return this;
    }


    public boolean getChecked() {
        return checked;
    }


    @Override
    public void clickEvent(float xpos, float ypos) {
        if(rect.left <= xpos && xpos <= rect.right && rect.top <= ypos && ypos <= rect.bottom) {
            System.out.println("Changed state");
            checked = !checked;
        }
    }


    @Override
    protected void renderState() {
        if(checked) {
            glBegin(GL_QUADS);
            glColor3f(0.1f, 0.1f, 0.1f);
            Rectangle<Float> checkmark = new Rectangle<>(
                    rect.left + abs(rect.left - rect.right)*0.1f,
                    rect.right - abs(rect.left - rect.right)*0.1f,
                    rect.bottom - abs(rect.bottom - rect.top)*0.1f,
                    rect.top + abs(rect.bottom - rect.top)*0.1f);
            glVertex2f(checkmark.left, checkmark.bottom);
            glVertex2f(checkmark.left, checkmark.top);
            glVertex2f(checkmark.right, checkmark.top);
            glVertex2f(checkmark.right, checkmark.bottom);
            glEnd();
        }
    }
}
