package View;

import Presenter.Presenter;


public class View implements Runnable, AutoCloseable {

    private Presenter presenter;


    public View() {
        System.out.println("View      : ()");
        Renderer.init();
    }


    public void close() {
        Renderer.finish();
    }


    public void run() {

        try(Renderer gameRenderer = new Renderer(this)) {
            gameRenderer.createWindow();
            gameRenderer.run();
        }
    }


    public void setPresenter(Presenter presenter) {
        System.out.println("View      : adding presenter");
        this.presenter = presenter;
    }
}


