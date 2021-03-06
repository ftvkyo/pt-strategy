package Model.Unit.UnitUpgrade;

import Model.Item.GenericItem;
import Model.Player.Player;
import Model.Unit.IUnit;
import Model.Unit.UnitAction.IAction;

import java.util.ArrayList;
import java.util.HashSet;


/**
 * Реализация паттерна Decorator.
 * Позволяет нам писать новые классы, которые декорируют Units,
 * и добавлять новые возможности этим Units.
 * <p>
 * Unit'ы, конечно, должны декорироваться в процессе выполнения программы.
 * Таким образом мы сможем декорировать любые Unit'ы
 * и изменять их поведение так, как нам угодно.
 * <p>
 * У этого паттерна, правда, есть одна проблема: если мы много раз будем декорировать Unit,
 * вызов методов этого Unit'a будет работать дольше (если это не оптимизируется компилятором).
 * <p>
 * //TODO: Should i Implement "Remove Decorator" method?
 */
class GenericUnitUpgrade implements IUnit {

    /**
     * Юнит, который будет декорироваться.
     */
    IUnit decorated;


    /**
     * Package private конструктор.
     */
    GenericUnitUpgrade() {
    }


    @Override
    public void removeItem(GenericItem item) {
        this.decorated.removeItem(item);
    }


    @Override
    public void addItem(GenericItem item) {
        this.decorated.addItem(item);
    }


    @Override
    public int getActionPoints() {
        return this.decorated.getActionPoints();
    }


    @Override
    public void zeroActionPoints() {
        this.decorated.zeroActionPoints();
    }


    @Override
    public void zeroHealthPoints() {
        this.decorated.zeroHealthPoints();
    }


    @Override
    public int getDamagePoints() {
        return this.decorated.getDamagePoints();
    }

    @Override
    public Player getOwner() { return this.decorated.getOwner(); }


    @Override
    public int getHealthPoints() {
        return this.decorated.getHealthPoints();
    }


    @Override
    public boolean getCanIgnoreCounterAttack() {
        return this.decorated.getCanIgnoreCounterAttack();
    }


    @Override
    public HashSet<IAction> getAvailableActions() {
        return this.decorated.getAvailableActions();
    }


    @Override
    public void restoreActionPoints() {
        this.decorated.restoreActionPoints();
    }


    @Override
    public void restoreAllPoints() {
        this.decorated.restoreAllPoints();
    }


    @Override
    public void changeActionPoints(int delta) {
        this.decorated.changeActionPoints(delta);
    }


    @Override
    public void changeHealthPoints(int delta) {
        this.decorated.changeHealthPoints(delta);
    }


    @Override
    public ArrayList<GenericItem> getItems() {
        return this.decorated.getItems();
    }


    @Override
    public void activateItem(int n, IUnit targetUnit) {
        this.decorated.activateItem(n, targetUnit);
    }
}
