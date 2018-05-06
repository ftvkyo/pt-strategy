package Model.Unit.UnitUpgrade;

import Model.Item.GenericItem;
import Model.Unit.IUnit;
import Model.Unit.UnitAction.Action;

import java.util.ArrayList;

/**
 * Implementation of Decorator pattern.
 * Allows us to write new classes, that decorate our units,
 * and add new abilities for these units.
 *
 * Units should be decorated at runtime, of course.
 * The power of this solution, that we can decorate any types of units
 * and change behavior of units as we want.
 *
 * This pattern have one problem - if we decorate the unit many times,
 * calls of unit's methods will work longer (if compiler doesn't optimize it).
 *
 * //TODO: Should i Implement "Remove Decorator" method?
 */
class GenericUnitUpgrade implements IUnit {

    /**
     * The Unit that we are decorating.
     */
    IUnit decorated;


    /**
     * Hidden decorator (package private).
     */
    GenericUnitUpgrade() {}


    @Override
    public void removeItem(int n) {
        this.decorated.removeItem(n);
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
    public Action.ActionResult zeroActionPoints() {
        return this.decorated.zeroActionPoints();
    }


    @Override
    public int getDamagePoints() {
        return this.decorated.getDamagePoints();
    }


    @Override
    public int getHealthPoints() {
        return this.decorated.getHealthPoints();
    }


    @Override
    public boolean getCanIgnoreCounterAttack() {
        return this.decorated.getCanIgnoreCounterAttack();
    }


    @Override
    public ArrayList<Action> getAvailableActions() {
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
    public Action.ActionResult ableToAttack() {
        return this.decorated.ableToAttack();
    }


    @Override
    public Action.ActionResult changeActionPoints(int n) {
        return this.decorated.changeActionPoints(n);
    }


    @Override
    public Action.ActionResult changeHealthPoints(int n) {
        return this.decorated.changeHealthPoints(n);
    }


    @Override
    public ArrayList<GenericItem> getItems() {
        return this.decorated.getItems();
    }

}
