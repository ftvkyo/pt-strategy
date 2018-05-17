package View;

import View.Misc.InterfaceElement;


class GameInterfaceElement extends InterfaceElement {

    GameInterfaceElement(View view) {
        children.add(new GameMapInterfaceElement()
                .setRectangle(0f, Renderer.windowWidth*0.66f, Renderer.windowHeight, 0f));

        children.add(new GameMenuInterfaceElement()
                .setRectangle(Renderer.windowWidth*0.66f, Renderer.windowWidth, Renderer.windowHeight, 0f));
    }
}
