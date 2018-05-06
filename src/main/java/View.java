public class View {
    private Controller controller;

    public View() {
        controller = new Controller();
    }

    public void run() {
        //Здесь должен быть код, отвечающий за графику игры
        //Он будет делать запросы в Controller, который будет говорить ему, что нужно нарисовать
        //View никак не должен взаимодействовать с Model.
    }
}
