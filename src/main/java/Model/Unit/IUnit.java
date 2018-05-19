package Model.Unit;

import Model.Item.GenericItem;
import Model.Player.Player;
import Model.Unit.UnitAction.IAction;

import java.util.ArrayList;
import java.util.HashSet;


/**
 * Интерфейс Unit'ов. Следует использовать его вместо GenericUnit везде, где это возможно.
 */
public interface IUnit {

    /**
     * Метод для обновления значений всех возможных Points до максимальных значений.
     */
    void restoreAllPoints();


    /**
     * Метод для обновления значения Action Points.
     */
    void restoreActionPoints();


    /**
     * Метод для изменения (уменьшения или увеличения) значения Health Points.
     *
     * @param delta число, на которое нужно изменить Health Points
     */
    void changeHealthPoints(int delta);


    /**
     * Метод для изменения (уменьшения или увеличения) значения Action Points.
     *
     * @param delta число, на которое нужно изменить Action Points
     */
    void changeActionPoints(int delta);


    /**
     * Метод для обнуления Action Points.
     * Полезен для атак (как в Sid Meier's Civilization)
     */
    void zeroActionPoints();


    /**
     * Метод для обнуления Health Points.
     */
    void zeroHealthPoints();


    /**
     * Геттер для Health Points.
     *
     * @return текущее значение Health Points
     */
    int getHealthPoints();


    /**
     * Геттер для Action Points.
     *
     * @return текущее значение Action Points
     */
    int getActionPoints();


    /**
     * Геттер для Damage Points.
     *
     * @return текущее значение Damage Points
     */
    int getDamagePoints();

    /**
     * Геттер хозяин
     * @return владелец юнита
     */
    Player getOwner();


    /**
     * Некоторые Unit'ы (лучники) могут игнорировать ответные атаки,
     * и этот метод -- геттер для способности данного Unit'a делать это.
     *
     * @return true, если Unit имеет способность игнорировать ответную атаку, false иначе
     */
    boolean getCanIgnoreCounterAttack();


    /**
     * Геттер для инвентаря данного Unit'a.
     *
     * @return массив Items -- инвентарь
     */
    ArrayList<GenericItem> getItems();


    /**
     * Метод для добавления Item'a в инвентарь данного Unit'a.
     *
     * @param item Item, который будет добавлен в инвентарь
     */
    void addItem(GenericItem item);


    /**
     * Метод для удаления n-ного Item'a из инвентаря данного Unit'a.
     *
     * @param item, который будет удален из инвентаря
     */
    void removeItem(GenericItem item);


    /**
     * Геттер для доступных данному Unit'у действий
     *
     * @return множество доступных данному Unit'у действий
     */
    HashSet<IAction> getAvailableActions();
}
