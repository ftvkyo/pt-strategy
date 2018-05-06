public class View {
    private final Controller controller = new Controller();

    public View() {}

    public void run() {
        //Здесь должен быть код, отвечающий за графику игры
        //Он будет делать запросы в Controller, который будет говорить ему, что нужно нарисовать
        //View никак не должен взаимодействовать с Model.
    }
}
