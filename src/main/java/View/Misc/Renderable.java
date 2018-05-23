package View.Misc;


import Controller.Controller;
import View.InterfaceDescription.RenderableDescription;
import View.Notification.INotification;
import View.Notification.INotificationReceiver;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Map;

import static org.lwjgl.opengl.GL11.*;


public class Renderable implements INotificationReceiver {

    protected float colorR, colorG, colorB;

    protected float left, right, bottom, top;

    protected final ArrayList<Renderable> children = new ArrayList<>();

    protected Runnable action = null;

    protected Controller controller = null;

    protected String id = null;


    public Renderable() {}


    public Renderable(@NotNull Controller controller, @NotNull String id, @NotNull RenderableDescription description) {
        this.id = id;
        this.controller = controller;

        setColor(description.color.get(0),
                description.color.get(1),
                description.color.get(2));
        setShape(description.coords.get(0),
                description.coords.get(1),
                description.coords.get(2),
                description.coords.get(3));
        setAction(controller.getCallback(id));

        for(Map.Entry<String, RenderableDescription> renderable : description.children.entrySet()) {
            String renderableType = renderable.getValue().type;
            switch(renderableType) {
                case "button":
                case "container":
                    children.add(new Renderable(controller, renderable.getKey(), renderable.getValue()));
                    break;
                case "checkbox":
                    children.add(new Checkbox(controller, renderable.getKey(), renderable.getValue()));
                    break;
                case "game-map":
                    children.add(new GameMap(controller, renderable.getKey(), renderable.getValue()));
                    break;
            }
        }
    }


    public void setColor(float r, float g, float b) {
        this.colorR = r;
        this.colorG = g;
        this.colorB = b;
    }


    public void setAction(Runnable action) {
        this.action = action;
    }


    public void setShape(float left, float right, float bottom, float top) {
        this.left = left;
        this.right = right;
        this.bottom = bottom;
        this.top = top;
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


    @Override
    public void receiveNotification(INotification n) {
        for(Renderable child : children) {
            child.receiveNotification(n);
        }
    }
}
