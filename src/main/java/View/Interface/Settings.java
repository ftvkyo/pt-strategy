package View.Interface;

import View.Rectangle;

import static org.lwjgl.opengl.GL11.*;

public class Settings implements Renderable {

    private View.Rectangle<Float> rect;

    public Settings() {
        rect = new Rectangle<>(-1f, 1f, -1f, 1f);
    }

    public Settings setRectangle(View.Rectangle<Float> r) {
        rect = r;
        return this;
    }

    @Override
    public void render(Object o) {

        glBegin(GL_QUADS);
        glColor3f(0.0f, 0.2f, 0.2f);
        glVertex2f(rect.xLeft, rect.yBottom);
        glVertex2f(rect.xLeft, rect.yTop);
        glVertex2f(rect.xRight, rect.yTop);
        glVertex2f(rect.xRight, rect.yBottom);
        glEnd();
    }
}
