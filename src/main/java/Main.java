import Controller.Controller;
import Model.Model;
import View.View;


public class Main {

    public static void main(String[] args) {


        try(Controller controller = new Controller();
            View view = new View(controller);
            Model model = new Model()) {

            model.setView(view);
            controller.setModel(model);

            view.run();
        }
    }
}
