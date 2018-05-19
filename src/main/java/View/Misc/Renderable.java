package View.Misc;


import Controller.Controller;

import java.util.ArrayList;

import static org.lwjgl.opengl.GL11.*;


public class Renderable {

    protected float colorR, colorG, colorB;

    protected float left, right, bottom, top;

    private ArrayList<Renderable> children = new ArrayList<>();

    private Runnable action = null;

    protected Controller controller;


    public Renderable() {}


    public Renderable(float windowWidth, float windowHeight) {
        this.colorR = 0f;
        this.colorG = 0f;
        this.colorB = 0f;

        this.left = 0f;
        this.right = windowWidth;
        this.bottom = windowHeight;
        this.top = 0f;
    }


    public final Renderable setColor(float colorR, float colorG, float colorB) {
        this.colorR = colorR;
        this.colorG = colorG;
        this.colorB = colorB;

        return this;
    }


    public final Renderable setRectangle(float left, float right, float bottom, float top) {
        this.left = left;
        this.right = right;
        this.bottom = bottom;
        this.top = top;

        return this;
    }


    public final Renderable setAction(Runnable action) {
        this.action = action;

        return this;
    }


    public final Renderable addChild(Renderable r) {
        children.add(r);

        return this;
    }


    public void setController(Controller controller) {
        this.controller = controller;
        for(Renderable child : children) {
            child.setController(controller);
        }
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

        for(Renderable child : children) {
            child.render();
        }
    }


    public void clickEvent(float xPosition, float yPosition) {
        if(left <= xPosition && xPosition <= right && top <= yPosition && yPosition <= bottom) {
            for(Renderable child : children) {
                child.clickEvent(xPosition, yPosition);
            }
            if(action != null) {
                action.run();
            }
        }
    }


    protected void renderState() {
    }
}
