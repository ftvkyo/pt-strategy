import Model.Model;
import Presenter.Presenter;
import View.View;


public class Main {

    public static void main(String[] args) {
        Model m = new Model();

        try(View v = new View()) {
            Presenter p = new Presenter();

            v.setPresenter(p);
            p.setModel(m);

            v.run();
        }
    }
}
