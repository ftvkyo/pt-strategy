package View;


import View.Misc.Renderable;
import View.Notification.INotification;
import View.Notification.INotificationReceiver;


class GameMenuRenderable extends Renderable implements INotificationReceiver {

    GameMenuRenderable() {
        colorR = 0.5f;
        colorG = 0.5f;
        colorB = 0.5f;
    }


    @Override
    public void receiveNotification(INotification n) {}
}
