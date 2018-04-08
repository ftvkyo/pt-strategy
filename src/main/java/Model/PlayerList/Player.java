package Model.PlayerList;

import java.util.ArrayList;

public class Player extends  PlayerListExample {

    //Здесь должно в каком-то виде храниться состояние модели, то есть состояние игрока
    // - сколько у игрока сейчас ресурсов, как зовут игрока

    ArrayList playerList = new ArrayList();
    String name;

    Player (String name) {
        this.name = name;
    }

    public void add (PlayerListComponent component) {
        playerList.add(component);
    }
    public void remove (PlayerListComponent component) {
        playerList.remove(component);
    }

    public PlayerListComponent getChild(int i) {
        return (PlayerListComponent) playerList.get(i);
    }
    public String getName() {
        return name;
    }
}
