package View.Interface;


import View.Rectangle;

import static org.lwjgl.opengl.GL11.*;


public abstract class Renderable {

    protected Rectangle<Float> rect;

    protected float colorR, colorG, colorB;


    public Renderable setRectangle(float left, float right, float bottom, float top) {
        rect = new Rectangle<>(left, right, bottom, top);
        return this;
    }


    public void render() {
        glBegin(GL_QUADS);
        glColor3f(colorR, colorG, colorB);
        glVertex2f(rect.left, rect.bottom);
        glVertex2f(rect.left, rect.top);
        glVertex2f(rect.right, rect.top);
        glVertex2f(rect.right, rect.bottom);
        glEnd();

        renderState();
    }


    protected void renderState() {
    }


    public void clickEvent(float xpos, float ypos) {
        if(rect.left <= xpos && xpos <= rect.right && rect.top <= ypos && ypos <= rect.bottom) {
            clickEvent();
        }
    }


    protected void clickEvent() {
    }
}
