package View.Misc;


import Controller.Controller;
import View.InterfaceDescription.RenderableDescription;
import View.Notification.CheckboxUpdate;
import View.Notification.INotification;

import static java.lang.Math.abs;
import static org.lwjgl.opengl.GL11.*;


public class Checkbox extends Renderable {

    private static final float margin = 0.2f;

    private boolean checked = false;


    public Checkbox(Controller controller, String id, RenderableDescription description) {
        super(controller, id, description);
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


    @Override
    public void receiveNotification(INotification n) {
        if(n instanceof CheckboxUpdate) {
            if(((CheckboxUpdate) n).getCheckboxID().equals(id)) {
                checked = ((CheckboxUpdate) n).getUpdateTo();
            }
        }
    }
}
