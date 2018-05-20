import Controller.Controller;
import Model.Model;
import View.View;


public class Main {

    public static void main(String[] args) {
        Renderer.init();

        try(Renderer   renderer   = new Renderer()) {

            Model      model      = new Model();
            View       view       = new View(Renderer.windowWidth, Renderer.windowHeight);
            Controller controller = new Controller();

            renderer.setView(view);
            renderer.setController(controller);

            controller.setModel(model);
            view.setController(controller);
            model.setReceiver(view);

            renderer.run();
        }


        Renderer.finish();
    }
}
