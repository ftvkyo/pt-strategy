package View;


public class Rectangle<T> {

    public T xLeft, xRight, yBottom, yTop;


    public Rectangle() {
    }


    public Rectangle(T left, T right, T bottom, T top) {
        xLeft = left;
        xRight = right;
        yBottom = bottom;
        yTop = top;
    }
}
