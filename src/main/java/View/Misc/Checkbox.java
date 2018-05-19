package View.Misc;


import static java.lang.Math.abs;
import static org.lwjgl.opengl.GL11.*;


public class Checkbox extends Renderable {

    private static float margin = 0.2f;

    private boolean checked = false;


    public Checkbox() {
    }


    public Checkbox setChecked(boolean checked) {
        this.checked = checked;
        return this;
    }


    @Override
    protected void renderState() {
        if(checked) {
            glBegin(GL_QUADS);
            glColor3f(0.1f, 0.1f, 0.1f);
            float leftT = left + abs(left - right)*margin;
            float rightT = right - abs(left - right)*margin;
            float bottomT = bottom - abs(bottom - top)*margin;
            float topT = top + abs(bottom - top)*margin;
            glVertex2f(leftT, bottomT);
            glVertex2f(leftT, topT);
            glVertex2f(rightT, topT);
            glVertex2f(rightT, bottomT);
            glEnd();
        }
    }
}
