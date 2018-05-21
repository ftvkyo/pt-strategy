package View;


import View.Misc.Renderable;
import View.Notification.INotification;
import View.Notification.INotificationReceiver;


class GameMenuRenderable extends Renderable implements INotificationReceiver {

    GameMenuRenderable() {
        colorR = 0.1f;
        colorG = 0.1f;
        colorB = 0.1f;
    }


    @Override
    public void receiveNotification(INotification n) {}
}
