package Model.Landscape;

import Model.HasIdentifier;
import Model.Item.GenericItem;
import Model.Unit.IUnit;

import java.util.ArrayList;


abstract public class GenericLandscape implements HasIdentifier {

    /**
     * Action Points, необходимые для того,
     * чтобы пройти по этому Landscape.
     */
    private int passableness;


    /**
     * Unit, находящийся на данном Landscape.
     */
    private IUnit unit;


    /**
     * Item'ы, находящиеся на данном Landscape.
     */
    private ArrayList<GenericItem> items = new ArrayList<>();


    /**
     * Сэттер для "проходимости" этого Landscape.
     *
     * @param p положительное число для
     *          "проходимости" этого Landscape
     */
    void setPassableness(int p) {
        passableness = p;
    }


    /**
     * Геттер для "проходимости" данного Landscape.
     *
     * @return "проходимость" данного Landscape
     */
    public int getPassableness() {
        return passableness;
    }


    /**
     * Метод для помещения Unit'a на данный Landscape.
     *
     * @param un Unit, который будет помещен на данный Landscape
     */
    public void setUnit(IUnit un) {
        this.unit = un;
    }


    /**
     * Метод для получения Unit'a, находящегося на данном Landscape.
     *
     * @return Unit, пребывающий на этом Landscape
     */
    public IUnit getUnit() {
        return this.unit;
    }


    /**
     * Метод для обмена местами Unit'ов (на этом Landscape and на Landscape l).
     *
     * @param l Landscape, с находящимся на котором Unit'ом
     *          будет меняться местами Unit на данном Landscape
     */
    public void swapUnit(GenericLandscape l) {
        IUnit tmp = l.getUnit();
        l.setUnit(this.getUnit());
        this.setUnit(tmp);
    }


    /**
     * Метод для добавления Item на данный Landscape.
     *
     * @param item Item для помещения на этот Landscape
     */
    public void addItem(GenericItem item) {
        items.add(item);
    }


    /**
     * Метод для выяснения, какие Item'ы находятся на данном Landscape.
     *
     * @return копия массива Item'ов, находящихся на данном Landscape
     */
    public ArrayList<GenericItem> getItems() {
        return new ArrayList<>(items);
    }


    /**
     * Метод для удаленния n-ного Item'a с данного Landscape.
     *
     * @param n номер Item'a для удаления
     */
    public void removeItem(int n) {
        items.remove(n);
    }


    /**
     * Класс для паттерна Factory Method.
     */
    abstract public static class GenericLandscapeFactory {

        /**
         * Factory method.
         *
         * @return сгенерированный объект Landscape
         */
        abstract public GenericLandscape createInstance();
    }
}
