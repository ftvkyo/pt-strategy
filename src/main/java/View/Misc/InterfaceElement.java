package View.Misc;


import View.Renderer;

import java.util.ArrayList;

import static org.lwjgl.opengl.GL11.*;


public class InterfaceElement {

    protected float colorR, colorG, colorB;

    protected float left, right, bottom, top;

    protected ArrayList<InterfaceElement> children = new ArrayList<>();

    private Runnable action = null;


    public InterfaceElement() {
        this.colorR = 0;
        this.colorG = 0;
        this.colorB = 0;

        this.left = 0f;
        this.right = Renderer.windowWidth;
        this.bottom = Renderer.windowHeight;
        this.top = 0f;
    }


    public final InterfaceElement setColor(float colorR, float colorG, float colorB) {
        this.colorR = colorR;
        this.colorG = colorG;
        this.colorB = colorB;

        return this;
    }


    public final InterfaceElement setRectangle(float left, float right, float bottom, float top) {
        this.left = left;
        this.right = right;
        this.bottom = bottom;
        this.top = top;

        return this;
    }


    public final InterfaceElement setAction(Runnable action) {
        this.action = action;

        return this;
    }


    public final void render() {
        glBegin(GL_QUADS);
        glColor3f(colorR, colorG, colorB);
        glVertex2f(left, bottom);
        glVertex2f(left, top);
        glVertex2f(right, top);
        glVertex2f(right, bottom);
        glEnd();

        renderState();

        for(InterfaceElement child : children) {
            child.render();
        }
    }


    protected void renderState() {
    }


    public final void clickEvent(float xPosition, float yPosition) {
        if(left <= xPosition && xPosition <= right && top <= yPosition && yPosition <= bottom) {
            for(InterfaceElement child : children) {
                child.clickEvent(xPosition, yPosition);
            }
            if(action != null) {
                action.run();
            }
        }
    }
}
