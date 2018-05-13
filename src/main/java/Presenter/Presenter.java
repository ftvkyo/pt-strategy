package Presenter;

import Model.Model;

import java.util.HashMap;
import java.util.Map;


/**
 * Связующее звено между View и Model
 * Получает запросы из View, перенаправляет их в Model, обрабатывает ответ и отправляет в View.
 */
public class Presenter {

    private Model model;


    public Presenter() {
        System.out.println("Presenter : ()");
    }


    public void setModel(Model m) {
        System.out.println("Presenter : adding model");
        this.model = m;
    }


    public Map<String, Object> getState() {
        return new HashMap<>();
    }
}
