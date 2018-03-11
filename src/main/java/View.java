public class View {
    private Presenter presenter;

    public View() {
        presenter = new Presenter();
    }

    public void run() {
        //Здесь должен быть код, отвечающий за графику игры
        //Он будет делать запросы в Presenter, который будет говорить ему, что нужно нарисовать
        //View никак не должен взаимодействовать с Model.
    }
}
