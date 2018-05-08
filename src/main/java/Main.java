import Controller.Controller;
import Model.Model;
import View.View;

public class Main {
    public static void main(String[] args) {
        Model m = new Model();

        try(View v = new View()) {
            Controller c = new Controller();

            m.addObserver(v);

            v.addController(c);

            c.addModel(m);
            c.addView(v);

            v.run();
        }
    }
}
