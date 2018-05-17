package View.Misc;


import static java.lang.Math.abs;
import static org.lwjgl.opengl.GL11.*;


public class Tickbox extends InterfaceElement {

    private boolean checked = false;

    Runnable action = () -> {
        System.out.println("Changed state");
        checked = !checked;
    };


    public Tickbox setChecked(boolean checked) {
        this.checked = checked;
        return this;
    }


    public boolean getChecked() {
        return checked;
    }


    @Override
    protected void renderState() {
        if(checked) {
            glBegin(GL_QUADS);
            glColor3f(0.1f, 0.1f, 0.1f);
            float leftT = left + abs(left - right)*0.1f;
            float rightT = right - abs(left - right)*0.1f;
            float bottomT = bottom - abs(bottom - top)*0.1f;
            float topT = top + abs(bottom - top)*0.1f;
            glVertex2f(leftT, bottomT);
            glVertex2f(leftT, topT);
            glVertex2f(rightT, topT);
            glVertex2f(rightT, bottomT);
            glEnd();
        }
    }
}
