package View;

import Controller.Controller;
import View.Misc.InterfaceElement;


class SettingsInterfaceElement extends InterfaceElement {

    public SettingsInterfaceElement(View view) {
        //FIXME
        left = 0f;
        right = Renderer.windowHeight;
        bottom = Renderer.windowWidth;
        top = 0f;

        children.add(new InterfaceElement()
                .setColor(0.5f, 0.9f, 0.5f)
                .setRectangle(1f, 2f, 2f, 1f)
                .setAction(view.getCallback(Controller.Callback.START_GAME)));

        children.add(new InterfaceElement()
                .setColor(0.9f, 0.5f, 0.5f)
                .setRectangle(3f, 4f, 2f, 1f)
                .setAction(view.getCallback(Controller.Callback.RESTART_GAME)));
    }
}
