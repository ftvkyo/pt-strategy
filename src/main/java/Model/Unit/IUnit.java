package Model.Unit;

import Model.Item.*;
import java.util.ArrayList;

public interface IUnit {
    //Интерфейс Юнита
    //Как минимум - получить содержимое инвентаря, взаимодействовие с его содержимым.
    //Получить количество очков действия, вычесть или увеличить их количество.
    ArrayList<IItem> getItems();
    void addItem(IItem item);
    void removeItem(int n);
}
