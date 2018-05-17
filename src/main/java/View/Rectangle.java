package View;


public class Rectangle<T> {

    public T left, right, bottom, top;


    public Rectangle() {
    }


    public Rectangle(T left, T right, T bottom, T top) {
        this.left = left;
        this.right = right;
        this.bottom = bottom;
        this.top = top;
    }
}
