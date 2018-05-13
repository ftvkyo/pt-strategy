package View.Interface;

import static org.lwjgl.opengl.GL11.*;

class Menu implements Renderable {

    private View.Rectangle<Float> rect;

    public Menu setRectangle(View.Rectangle<Float> r) {
        rect = r;
        return this;
    }

    @Override
    public void render(Object o) {

        glBegin(GL_QUADS);
        glColor3f(0.0f, 0.5f, 0.9f);
        glVertex2f(rect.xLeft, rect.yBottom);
        glVertex2f(rect.xLeft, rect.yTop);
        glVertex2f(rect.xRight, rect.yTop);
        glVertex2f(rect.xRight, rect.yBottom);
        glEnd();
    }
}
