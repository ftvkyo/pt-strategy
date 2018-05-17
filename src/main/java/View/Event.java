package View;

import Controller.Controller;

public class Event {
    public enum Type {
        CLICK
    }

    public Type type;
    public Controller.Controls control;

    Event(Type t, Controller.Controls c) {
        this.type = t;
        this.control = c;
    }
}
