package Model.Unit;

import Model.Player.Player;


/**
 * Часть реализации паттерна Builder.
 */
public class UnitBuilder {

    /**
     * Текущий UnitMaker.
     */
    private GenericUnit.GenericUnitMaker maker;


    /**
     * Владелец данного UnitBuilder'a и создаваемых Unit'ов.
     */
    private Player owner;


    /**
     * Сэттер для UnitMaker'a.
     *
     * @param maker UnitMaker, который будет использоваться
     */
    public void setMaker(GenericUnit.GenericUnitMaker maker) {
        this.maker = maker;
    }


    /**
     * Сэттер для владельца UnitBuilder'a и создаваемых Unit'ов.
     *
     * @param owner владелец UnitBuilder'a и создаваемых Unit'ов
     */
    public void setOwner(Player owner) {
        this.owner = owner;
    }


    /**
     * Геттер для текущего владельца UnitBuilder'a и создаваемых Unit'ов.
     *
     * @return текущий владелец UnitBuilder'a и создаваемых Unit'ов
     */
    public Player getOwner() {
        return owner;
    }


    /**
     * Главный метод для создания Unit'ов.
     * Сэттеры для создателя Maker'a и владельца должны быть вызваны раньше, чем этот метод.
     *
     * @return созданный Unit
     */
    public IUnit buildNewUnit() {
        maker.createUnit();
        maker.setOwner(this.owner);
        maker.setDefaults();
        maker.setInventory();
        maker.setActions();
        return maker.getUnit();
    }
}
