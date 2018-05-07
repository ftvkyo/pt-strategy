package Controller;

import Model.Model;
import View.View;

/**
 * Связующее звено между View и Model
 * Получает запросы из View, перенаправляет их в Model, обрабатывает ответ и отправляет в View.
 */
public class Controller{

    Model model;
    View view;


    public Controller() {
        System.out.println ("Controller: ()");
    }


    //invoked when a button is pressed
    public void actionPerformed(){
        System.out.println("Controller: acting on Model");
    }


    public void addModel(Model m){
        System.out.println("Controller: adding model");
        this.model = m;
    }


    public void addView(View v){
        System.out.println("Controller: adding view");
        this.view = v;
    }


    public void initModel(){

    }

}
